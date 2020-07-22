package com.thoughtworks.helloworld;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLifeCyclePracticeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_lifecycle);

        Log.d("lifecycle", "on create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "on resume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "on pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "on destroy");
    }
}
