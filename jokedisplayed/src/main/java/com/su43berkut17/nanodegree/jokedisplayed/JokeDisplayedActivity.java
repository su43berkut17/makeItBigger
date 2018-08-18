package com.su43berkut17.nanodegree.jokedisplayed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayedActivity extends AppCompatActivity {

    public TextView mJokeText;
    public static String NAME_RETRIEVED="JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayed);

        Intent intent=getIntent();

        if (intent.hasExtra(NAME_RETRIEVED)) {

            String jokeRetrieved = intent.getStringExtra(NAME_RETRIEVED);

            mJokeText = (TextView) findViewById(R.id.tvJokeContent);

            mJokeText.setText(jokeRetrieved);
        }

    }

}
