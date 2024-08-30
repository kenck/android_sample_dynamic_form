package com.example.myform.form;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyDialogError {
    public static void showDialog(Context context,String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setIcon(android.R.drawable.stat_sys_warning)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Whatever...
                        dialog.dismiss();
                    }
                }).show();
    }
}
