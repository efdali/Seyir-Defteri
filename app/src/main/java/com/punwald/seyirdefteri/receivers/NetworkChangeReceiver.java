package com.punwald.seyirdefteri.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.punwald.seyirdefteri.ui.utils.NetworkUtil;

public class NetworkChangeReceiver extends BroadcastReceiver {

    NetworkChange networkChange;

    @Override
    public void onReceive(Context context, Intent intent) {
        networkChange.OnNetworkChanged(NetworkUtil.isOnline(context));
    }

    public void setNetworkChange(NetworkChange networkChange) {
        this.networkChange = networkChange;
    }

    public interface NetworkChange{

        void OnNetworkChanged(boolean status);

    }
}
