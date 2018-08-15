package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AsyncSimpleTest implements EndpointsAsyncTask.InterfaceBackActivity{

    String SENT="THIS IS THE TEXT SENT ON THE ASYNCTASK";
    Context context;

    @Test
    public void testAsyncEndPoints() throws InterruptedException{
        assertTrue(true);

        final CountDownLatch latch=new CountDownLatch(1);
        context= InstrumentationRegistry.getContext();

        EndpointsAsyncTask testTask = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result){
                assertNotNull(result);
                if (result!=null){
                    String newSent="Hi, "+SENT;

                    Log.i("TEST","comparing 1:"+result+".");
                    Log.i("TEST","comparing 2:"+newSent+".");

                    Boolean condition;
                    if (result.length()==newSent.length()){
                        condition=true;
                    }else{
                        condition=false;
                    }

                    assertTrue(condition);
                    latch.countDown();
                }
            }
        };

        testTask.execute(new Pair<Context, String>(context,SENT));
        latch.await();
    }

    @Override
    public void getResults(String result) {
        Log.i("Interface","this is the result we get: "+result);
    }
}
