package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import android.support.v4.util.Pair;
import com.su43berkut17.nanodegree.javalibtelljoke.TellJokeLib;
import com.su43berkut17.nanodegree.jokedisplayed.JokeDisplayedActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.InterfaceBackActivity{
    //
    //@Nullable private IdlingResourceAsync mIdlingResourceAsync;
    @Nullable private String mTextWithJoke;

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

        //MessageDelayer.processMessage(mTextWithJoke,this,mIdlingResourceAsync);

        //AsyncTask mAsyncTask= new EndpointsAsyncTask();
        //mAsyncTask.execute(new Pair<Context, String>(this, jokeSend));
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this,jokeSend));
    }

    /*@Override
    public void onDone(String text) {
        //we see how to assess
        Log.i("TEST","we will initiate the new intent");
        mTextWithJoke=text;
    }

    @VisibleForTesting
    @NonNull
    public IdlingResourceAsync getmIdlingResourceAsync(){
        if (mIdlingResourceAsync==null){
            mIdlingResourceAsync=new IdlingResourceAsync();
        }
        return mIdlingResourceAsync;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/

    @Override
    public void getResults(String result) {
        //we send the joke as an extra intent
        Intent intent=new Intent(this, JokeDisplayedActivity.class);

        //extras
        intent.putExtra("JOKE",result);
        this.startActivity(intent);
    }
}
