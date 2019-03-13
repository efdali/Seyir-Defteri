package com.punwald.seyirdefteri.common;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.punwald.seyirdefteri.util.receiver.NetworkReceiver;

public abstract class BaseNetworkActivity extends AppCompatActivity implements NetworkReceiver.OnNetworkStateChanged {

    IntentFilter intentFilter;
    NetworkReceiver networkReceiver;

    protected boolean isOnline;
    
    protected abstract void getNetworkChange(boolean status);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNetworkReceiver();
    }

    public void initNetworkReceiver(){
        intentFilter=new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        networkReceiver=new NetworkReceiver();
        networkReceiver.setStateChanged(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkReceiver);
    }

    @Override
    public void onStateChanged(boolean status) {
        isOnline=status;
        getNetworkChange(status);
    }
}
