package com.su43berkut17.nanodegree.jokedisplayed;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeDisplayedActivity extends AppCompatActivity {

    TextView mJokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayed);

        Intent intent=getIntent();

        String jokeRetrieved=intent.getStringExtra("JOKE");

        mJokeText=(TextView)findViewById(R.id.tvJokeContent);

        mJokeText.setText(jokeRetrieved);

        /*ActionBar bar=getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);*/
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
