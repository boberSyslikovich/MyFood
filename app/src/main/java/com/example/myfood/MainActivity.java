package com.example.myfood;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void userActivityClick(View view) {
        Intent intent = new Intent(MainActivity.this, UserActivity.class);
        startActivity(intent);
    }

    public void cookActivityClick(View view) {
        Intent intent = new Intent(this, Authorization.class);
        startActivity(intent);
    }
}
