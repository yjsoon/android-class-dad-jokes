package com.tinkercademy.yjsoon.dadjokes;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class JokesListActivity extends ListActivity {

    private Joke[] mJokes = {
        new Joke("Can crusher", "Why did the can crusher quit his job?", "Because it was so depressing"),
        new Joke("Nose", "What do you call someone with a nose but no body?", "Nobody knows"),
        new Joke("Muffler", "Last night I dreamt I was a muffler", " I woke up exhausted")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_list);

        mJokes[0].setSeen(true); // for testing purposes

        JokeAdapter adapter;

        adapter = new JokeAdapter(this, R.layout.list_item_joke, mJokes);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, JokeDetailActivity.class);
        intent.putExtra(JokeDetailActivity.JOKE_DETAIL_TEXT, mJokes[position].getQuestion());
        intent.putExtra(JokeDetailActivity.JOKE_DETAIL_PUNCHLINE, mJokes[position].getAnswer());
        startActivity(intent);
    }

    private class JokeAdapter extends ArrayAdapter<Joke> {

        private int mResource;
        private Joke[] mJokes;

        public JokeAdapter(Context context, int resource, Joke[] jokes) {
            super(context, resource, jokes);
            mResource = resource;
            mJokes = jokes;
        }

        @Override
        public View getView(int position, View row, ViewGroup parent) {
            if (row == null) { // this lets Android recycle the row if necessary
                row = getLayoutInflater().inflate(mResource, parent, false);
            }

            Joke currentJoke = mJokes[position]; // get the joke at this position

            TextView textView = (TextView) row.findViewById(R.id.list_text);
            // set the text
            textView.setText(currentJoke.getTitle());

            ImageView imageView = (ImageView) row.findViewById(R.id.list_graphic);
            // set the image based on whether it's been seen
            if (currentJoke.isSeen()) {
                imageView.setImageResource(R.drawable.check);
            } else {
                imageView.setImageResource(R.drawable.exclamation);
            }

            return row;
        }
    }

}
