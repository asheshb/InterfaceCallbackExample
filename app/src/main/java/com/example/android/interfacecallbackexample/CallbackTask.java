package com.example.android.interfacecallbackexample;

import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by Ashesh on 8/20/2016.
 */

public class CallbackTask extends AsyncTask<Void, Void, String> {

    // This is the reference to the associated listener
    private final WeakReference<CallbackListener> weakCallbackListerner;

    private final int counter;

    public CallbackTask(CallbackListener callbackInterface, int counter) {
        // The listener reference is passed in through the constructor
        this.weakCallbackListerner = new WeakReference<CallbackListener>(callbackInterface);
        this.counter = counter;
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            Log.d("AsyncTask", "Going to sleep: " + counter);
            Thread.sleep(5000);


        } catch(Exception ex){

        }


        return "Call from Asynctask: " + counter;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        Log.d("AsyncTask", "Woke up after sleep: " + counter);
        CallbackListener callbackListener = weakCallbackListerner.get();
        if(callbackListener == null){
            Log.d("AsyncTask", "callbackListerner is null: " + counter);
        }
        callbackListener.onTaskDone(result, counter);


    }

}
