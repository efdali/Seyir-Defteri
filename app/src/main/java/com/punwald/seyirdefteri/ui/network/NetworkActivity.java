package com.punwald.seyirdefteri.ui.network;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.common.BaseNetworkActivity;
import com.punwald.seyirdefteri.ui.main.MainActivity;
import com.punwald.seyirdefteri.util.receiver.NetworkReceiver;

public class NetworkActivity extends BaseNetworkActivity {

   
    @Override
    protected void getNetworkChange(boolean status) {
        goMainActivity(status);        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);


    }
    
    public void goMainActivity(boolean status){
        if (status){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else
            Toast.makeText(this, "Bağlantı Yok!", Toast.LENGTH_SHORT).show();
    }

    public void refresh(View view){
        goMainActivity(isOnline);
    }
}
