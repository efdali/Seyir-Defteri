package com.punwald.seyirdefteri.ui.utils;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.punwald.seyirdefteri.R;

public class Snack {

    public static void onSucces(Activity activity, String message) {

        Snackbar snackbar = Snackbar.make(activity.findViewById(R.id.containerLayout), message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(Color.WHITE);
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.BLACK);
        snackbar.show();

    }

}
