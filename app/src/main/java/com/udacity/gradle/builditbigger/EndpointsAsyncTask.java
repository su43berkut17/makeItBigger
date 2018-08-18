package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import android.support.v4.util.Pair;
import android.util.Log;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private InterfaceBackActivity mBackActivity;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        //Log.i("ENDPOINTS","the parameters length is "+params[0].second);
        context = params[0].first;
        //String name = params[0].second;
        String name="test";
        //Log.i("ENDPOINTS","the parameter received is "+name);

        //we get the joke from the java library


        try {
            //we initiate the interface
            return myApiService.sayHi(name).execute().getData();
            //return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        /*Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        //we send the joke as an extra intent
        Intent intent=new Intent(context, JokeDisplayedActivity.class);

        //extras
        intent.putExtra("JOKE",result);
        context.startActivity(intent);*/

        Log.i("EndpointsAsync","the result is "+result);

        mBackActivity=(InterfaceBackActivity) context;
        mBackActivity.getResults(result);
    }

    public interface InterfaceBackActivity{
        void getResults(String result);
    }
}