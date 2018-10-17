package com.kamal.archcompnonents.splash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.kamal.archcompnonents.R;
import com.kamal.archcompnonents.corecomponents.BaseActivity;
import com.kamal.archcompnonents.dashboard.DashboardActivity;
import com.kamal.archcompnonents.databinding.ActivitySplashBinding;
import com.kamal.archcompnonents.utils.AppConstants;

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpViewBindings();
        startHandlerDelay();
        getSupportActionBar().hide();
    }


    //Setting up the View model and Data binding for the view
    private void setUpViewBindings() {
        ActivitySplashBinding activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        activitySplashBinding.executePendingBindings();
    }

    //Method to add delay in order to show static loader of loading here...
    private void startHandlerDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
                finish();
            }
        }, AppConstants.DELAY_TIME);
    }
}
