package com.punwald.seyirdefteri.ui.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.receivers.NetworkChangeReceiver;
import com.punwald.seyirdefteri.ui.activities.MainActivity;

public class NetworkActivity extends AppCompatActivity implements NetworkChangeReceiver.NetworkChange {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private boolean hasNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        intentFilter=new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        networkChangeReceiver=new NetworkChangeReceiver();
        networkChangeReceiver.setNetworkChange(this);

    }

    private void retry(){
        if (hasNetwork){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
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
        hasNetwork=status;
    }
}
