package com.punwald.seyirdefteri.ui.main;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.punwald.seyirdefteri.R;
import com.punwald.seyirdefteri.common.BaseNetworkActivity;
import com.punwald.seyirdefteri.ui.main.home.HomeFragment;
import com.punwald.seyirdefteri.ui.main.profile.ProfileFragment;
import com.punwald.seyirdefteri.ui.network.NetworkActivity;
import com.punwald.seyirdefteri.util.receiver.NetworkReceiver;

public class MainActivity extends BaseNetworkActivity {

    BottomNavigationView bottomNav;
    FrameLayout frameLayout;

    @Override
    protected void getNetworkChange(boolean status) {
        if (!status){
            startActivity(new Intent(this, NetworkActivity.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout=findViewById(R.id.main_framelayout);
        bottomNav=findViewById(R.id.main_bottom_nav);

        bottomNav.setOnNavigationItemReselectedListener(listener);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout,new HomeFragment()).commit();


    }

    BottomNavigationView.OnNavigationItemReselectedListener listener=new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

            boolean checkable = menuItem.isCheckable();
            menuItem.setCheckable(!checkable);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_framelayout, !checkable ? new HomeFragment() : new ProfileFragment()).commit();



        }
    };


}
