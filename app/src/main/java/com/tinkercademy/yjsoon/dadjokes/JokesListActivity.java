package com.tinkercademy.yjsoon.dadjokes;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


public class JokesListActivity extends ListActivity {

    private String[] mSampleJokes= {"The one about a donkey",
                                    "This is a great one",
                                    "You won't believe your eyes when you read this",
                                    "This cured my flu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_list);

        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSampleJokes);
        setListAdapter(adapter);

    }

}
