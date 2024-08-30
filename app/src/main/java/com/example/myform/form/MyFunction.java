package com.example.myform.form;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyFunction {
    public void functionA(Context contextThis,String funcText,boolean isBackground,boolean isShowMessage){
        String status="",code="",message="";

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        //onPreExecute() before to get into executor, as below
        Toast.makeText(contextThis,"Started "+funcText,Toast.LENGTH_LONG).show();
        if(!isBackground)
        {
            MyDialogWaiting.showDialog(contextThis,"Message from "+funcText);
        }

        executor.execute(new Runnable() {
            @Override
            public void run() {

                //Background work here
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                //UI Thread work here
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(contextThis,"Ended "+funcText,Toast.LENGTH_LONG).show();

                        if(!isBackground)
                        {
                            MyDialogWaiting.dismissDialog();
                        }

                        if(isShowMessage){
                            MyDialogSucceed.showDialog(contextThis,"Message","Succeed "+funcText);
                        }
                    }
                });
            }
        });
    }
    public void functionB(Context contextThis,String funcText,boolean isBackground,boolean isShowMessage){
        String status="",code="",message="";

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        //onPreExecute() before to get into executor, as below
        Toast.makeText(contextThis,"Started "+funcText,Toast.LENGTH_LONG).show();
        if(!isBackground)
        {
            MyDialogWaiting.showDialog(contextThis,"Message from "+funcText);
        }

        executor.execute(new Runnable() {
            @Override
            public void run() {

                //Background work here
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                //UI Thread work here
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(contextThis,"Ended "+funcText,Toast.LENGTH_LONG).show();

                        if(!isBackground)
                        {
                            MyDialogWaiting.dismissDialog();
                        }

                        if(isShowMessage){
                            MyDialogSucceed.showDialog(contextThis,"Message","Succeed "+funcText);
                        }
                    }
                });
            }
        });
    }
}
