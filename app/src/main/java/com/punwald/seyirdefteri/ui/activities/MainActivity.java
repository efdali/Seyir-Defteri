package com.punwald.seyirdefteri.ui.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.receivers.NetworkChangeReceiver;

public class MainActivity extends AppCompatActivity implements NetworkChangeReceiver.NetworkChange {

    IntentFilter intentFilter;
    NetworkChangeReceiver networkChangeReceiver;
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNetworkReceiver();
    }

    private void initNetworkReceiver() {

        intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        networkChangeReceiver=new NetworkChangeReceiver();
        networkChangeReceiver.setNetworkChange(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkChangeReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkChangeReceiver);
    }

    @Override
    public void OnNetworkChanged(boolean status) {
        if (!status) {
            startActivity(new Intent(this, NetworkActivity.class));
            finish();
        }
    }
}
