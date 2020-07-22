package com.thoughtworks.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TEST_TARGET", "debug");
    }


    public void toConstraint(View view) {
        Intent intent = new Intent(this, ConstraintActivity.class);
        startActivity(intent);
    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void toGetContactPage(View view) {
        Intent intent = new Intent(this, GetContactActivity.class);
        startActivity(intent);
    }
}