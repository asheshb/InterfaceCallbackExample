package com.example.android.interfacecallbackexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CallbackListener {
    private static int counter;
    TextView mResulttextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResulttextView = (TextView) findViewById(R.id.result_text_view);
        counter++;
        Log.d("MainActivity","onCreate: " + counter);


        CallbackTask callbackTask = new CallbackTask(this, counter);
        callbackTask.execute();
    }



    @Override
    public void onTaskDone(String response, int taskCounter){
        Log.d("MainActivity","onTaskDone: Main Counter " + counter + " Task Counter "+ taskCounter);
        mResulttextView.setText(response);
    }
}
