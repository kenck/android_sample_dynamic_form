package com.example.myform;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.myform.form.MyDialogSucceed;
import com.example.myform.form.MyDialogWaiting;
import com.example.myform.form.MyFormCreator;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecondActivity extends Activity {
    String jsonData = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //String jsonData="[{\"formID\":1,\"formName\":\"Sync. Data\",\"layouts\":[{\"layoutScroll\":\"VERTICAL\",\"layoutPadding\":10,\"controls\":[{\"controlID\":1,\"controlName\":\"tv1\",\"controlType\":\"TextView\"}]}]}]";
//        String jsonData = null;
//        try {
//            InputStream is = this.getAssets().open("data.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            jsonData = new String(buffer, StandardCharsets.UTF_8);
//        } catch (Exception ignored) {}
//
//        new MyFormCreator().MyLayoutParams(this,jsonData);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        MyDialogWaiting.showDialog(this,"Loading");

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream is = getAssets().open("data.json");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    jsonData = new String(buffer, StandardCharsets.UTF_8);
                } catch (Exception ignored) {}

                //UI Thread work here
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        new MyFormCreator().MyLayoutParams(SecondActivity.this,jsonData);
                        MyDialogWaiting.dismissDialog();
                    }
                });
            }
        });

    }
}