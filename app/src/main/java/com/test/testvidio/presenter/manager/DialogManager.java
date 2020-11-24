package com.test.testvidio.presenter.manager;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;


@EBean
public class DialogManager {

    @RootContext
    protected Context context;

    public void errorDialog(String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {

                    }
                });

        final AlertDialog alert = builder.create();
        alert.show();
    }
}
