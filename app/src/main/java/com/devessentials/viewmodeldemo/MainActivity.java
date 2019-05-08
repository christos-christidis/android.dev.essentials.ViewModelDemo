package com.devessentials.viewmodeldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devessentials.viewmodeldemo.ui.mainactivity.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
