package com.punwald.seyirdefteri.util.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.punwald.seyirdefteri.util.NetworkUtil;

public class NetworkReceiver extends BroadcastReceiver {
    private OnNetworkStateChanged stateChanged;

    @Override
    public void onReceive(Context context, Intent intent) {
        stateChanged.onStateChanged(NetworkUtil.getStatus(context));
    }

    public void setStateChanged(OnNetworkStateChanged stateChanged) {
        this.stateChanged = stateChanged;
    }

    public interface OnNetworkStateChanged {
        void onStateChanged(boolean status);
    }

}
