package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

//import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class AsyncSimpleTest implements EndpointsAsyncTask.InterfaceBackActivity{

    //String SENT="THIS IS THE TEXT SENT ON THE ASYNCTASK";
    private static final String TAG="TEST_ASYNC";
    Context context;

    @Test
    public void testAsyncEndPoints() throws InterruptedException{
        //assertTrue(true);
        //try {
            final CountDownLatch latch = new CountDownLatch(1);
            context = InstrumentationRegistry.getContext();

            EndpointsAsyncTask testTask = new EndpointsAsyncTask() {
                @Override
                protected void onPostExecute(String result) {
                    try {
                        assertNotNull(result);
                    } catch (AssertionError e) {
                        Log.i(TAG, "The received text has a null value " + e.getStackTrace().toString());
                        throw e;
                    }

                    if (result != null) {
                    /*String newSent="Hi, "+"";

                    Log.i("TEST","comparing 1:"+result+".");
                    Log.i("TEST","comparing 2:"+newSent+".");*/
                        Log.i(TAG, "This is the received text " + result);

                        try {
                            assertFalse(TextUtils.isEmpty(result));
                        }catch (AssertionError e){
                            Log.i(TAG, "The received text is empty " + e.getMessage());
                        }

                        /*Boolean condition;
                        if (result.length() > 0) {
                            condition = true;
                        } else {
                            condition = false;
                        }
                        try {
                            assertTrue(condition);
                        } catch (AssertionError e) {
                            Log.i(TAG, "The received text is empty " + e.getMessage());
                        }*/
                        latch.countDown();
                    }
                }
            };

            testTask.execute(context);
            latch.await();
        /*}catch (InterruptedException e){
            Log.i(TAG,"Interrupted exception "+e.getStackTrace().toString());
        }*/
    }

    @Override
    public void getResults(String result) {
        Log.i("Interface","this is the result we get: "+result);
    }
}
