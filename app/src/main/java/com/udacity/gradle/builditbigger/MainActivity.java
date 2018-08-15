package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import android.support.v4.util.Pair;
import com.su43berkut17.nanodegree.javalibtelljoke.TellJokeLib;
import com.su43berkut17.nanodegree.jokedisplayed.JokeDisplayedActivity;
import com.udacity.gradle.builditbigger.IdlingResource.IdlingResourceAsync;

public class MainActivity extends AppCompatActivity implements MessageDelayer.DelayerCallback{
    @Nullable private IdlingResourceAsync mIdlingResourceAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        TellJokeLib jokeProvider=new TellJokeLib();
        String jokeSend=jokeProvider.getJoke();

        MessageDelayer.processMessage(jokeSend,this,mIdlingResourceAsync);

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, jokeSend));
    }

    @Override
    public void onDone(String text) {
        //we see how to assess
    }

    @VisibleForTesting
    @NonNull
    public IdlingResourceAsync getmIdlingResourceAsync(){
        if (mIdlingResourceAsync==null){
            mIdlingResourceAsync=new IdlingResourceAsync();
        }
        return mIdlingResourceAsync;
    }
}
