package com.punwald.seyirdefteri.ui.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.receivers.NetworkChangeReceiver;
import com.punwald.seyirdefteri.ui.fragments.HomeFragment;
import com.punwald.seyirdefteri.ui.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity implements NetworkChangeReceiver.NetworkChange {

    private static final String HOME_FRAGMENT = "home_fragment";
    private static final String PROFILE_FRAGMENT = "profile_fragment";
    IntentFilter intentFilter;
    NetworkChangeReceiver networkChangeReceiver;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.frameLayout);

        final FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                boolean checkable = menuItem.isCheckable();
                menuItem.setCheckable(!checkable);

                fm.beginTransaction().replace(R.id.frameLayout, !checkable ? new HomeFragment() : new ProfileFragment()).commit();

            }
        });


        initNetworkReceiver();

    }

    private void initNetworkReceiver() {

        intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        networkChangeReceiver = new NetworkChangeReceiver();
        networkChangeReceiver.setNetworkChange(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkChangeReceiver, intentFilter);
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
