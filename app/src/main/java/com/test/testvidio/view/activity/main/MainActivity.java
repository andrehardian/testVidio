package com.test.testvidio.view.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import com.test.testvidio.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @Bean
    protected MainImpl impl;

    @AfterViews
    protected void init() {
        impl.initFragment(getSupportFragmentManager(), R.id.frame);
        impl.showList();
    }

    @Override
    public void onBackPressed() {
        impl.backpressed();
    }
}