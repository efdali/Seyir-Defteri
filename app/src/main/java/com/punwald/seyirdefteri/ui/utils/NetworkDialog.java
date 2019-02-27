package com.punwald.seyirdefteri.ui.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.punwald.seyirdefteri.R;

public class NetworkDialog extends AlertDialog {
    protected NetworkDialog(@NonNull Context context) {
        super(context);

        View view= LayoutInflater.from(context).inflate(R.layout.activity_network,null,false);

        this.setContentView(view);

    }
}
