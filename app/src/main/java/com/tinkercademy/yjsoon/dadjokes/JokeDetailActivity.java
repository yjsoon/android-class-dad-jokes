package com.tinkercademy.yjsoon.dadjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


public class JokeDetailActivity extends ActionBarActivity {

    private boolean mTappedOnce = false;
    public static final String JOKE_DETAIL_TEXT = "com.tinkercademy.yjsoon.dadjokes.joke_detail_text";
    public static final String JOKE_DETAIL_PUNCHLINE = "com.tinkercademy.yjsoon.dadjokes.joke_punchline";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);

        View jokeDetailView = findViewById(R.id.joke_detail_view);
        TextView jokeText = (TextView) findViewById(R.id.joke_text);
        // note -- this needs to be "final" to be accessible in a listener
        // see http://stackoverflow.com/questions/4732544/why-are-only-final-variables-accessible-in-anonymous-class
        final TextView jokePunchline = (TextView) findViewById(R.id.punchline_text);

        Intent intent = getIntent();
        jokeText.setText(intent.getStringExtra(JOKE_DETAIL_TEXT));
        jokePunchline.setText(intent.getStringExtra(JOKE_DETAIL_PUNCHLINE));

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
