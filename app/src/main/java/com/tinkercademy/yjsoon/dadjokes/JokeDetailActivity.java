package com.tinkercademy.yjsoon.dadjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


public class JokeDetailActivity extends ActionBarActivity {

    private boolean mTappedOnce = false;
    public static final String JOKE_PARCEL = "com.tinkercademy.yjsoon.dadjokes.joke_parcel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);

        View jokeDetailView = findViewById(R.id.joke_detail_view);
        TextView jokeText = (TextView) findViewById(R.id.joke_text);
        final TextView jokePunchline = (TextView) findViewById(R.id.punchline_text);

        Intent intent = getIntent();
        Joke joke = (Joke) intent.getParcelableExtra(JOKE_PARCEL);

        jokeText.setText(joke.getQuestion());
        jokePunchline.setText(joke.getAnswer());

        jokeDetailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mTappedOnce) { // haven't tapped yet, show the punchline
                    jokePunchline.setVisibility(View.VISIBLE);
                    mTappedOnce = true;
                } else { // tapped already? exit
                    finish();
                }
            }
        });

    }


}
