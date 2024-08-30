package com.example.myform.form;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.myform.module.MyControlEvent;
import com.example.myform.module.MyControlFunc;
import com.example.myform.module.MyControlModule;
import com.example.myform.module.MyEnum;
import com.example.myform.module.MyFormModule;
import com.example.myform.module.MyLayoutModule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

public class MyFormCreator {
    Context context;
    Activity myActivityThis;
    public void MyLayoutParams(Activity activityThis,String jsonData){
        myActivityThis=activityThis;
        context=activityThis.getApplicationContext();

        //controlParams
        LinearLayout.LayoutParams controlParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        //create the layout param for the layout
        LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        //parse json to object
        Gson gson = new Gson();
        //for list form
//        Type objType = new TypeToken<Collection<MyFormModule>>() {}.getType();
//        Collection<MyFormModule> obj = gson.fromJson(jsonData, objType);
        //for single form
        Type objType = new TypeToken<MyFormModule>() {}.getType();
        MyFormModule form = gson.fromJson(jsonData, objType);
        //read obj - form
        if (form != null) {
            //int formID = form.formID;
            //String formName = form.formName;
            List<MyLayoutModule> layouts=form.layouts;
            LinearLayout myLayouts = new LinearLayout(context);
            myLayouts.setOrientation(LinearLayout.VERTICAL);
            //loop obj - layout
            for(MyLayoutModule layout:layouts){
                String layoutScroll=layout.layoutScroll;
                int layoutPaddingLeft=layout.paddingLeft;
                int layoutPaddingTop=layout.paddingTop;
                int layoutPaddingRight=layout.paddingRight;
                int layoutPaddingBottom=layout.paddingBottom;
                List<MyControlModule> controls=layout.controls;

                //create layout
                LinearLayout myLayout = new LinearLayout(context);
                myLayout.setLayoutParams(layoutParam);
                myLayout.setPadding(layoutPaddingLeft,layoutPaddingTop,layoutPaddingRight,layoutPaddingBottom);
                myLayout.setOrientation(LinearLayout.HORIZONTAL);
                if(layoutScroll.equals("VERTICAL")){
                    myLayout.setOrientation(LinearLayout.VERTICAL);
                }

                //loop obj - control
                for(MyControlModule control:controls){
                    //int controlID=control.controlID;
                    //String controlName=control.controlName;
                    String controlType=control.controlType;//MyEnum->ControlType
                    if(controlType.equals(String.valueOf(MyEnum.ControlType.Button))){
                        Button myCtl = new Button(context);
                        myCtl.setText(control.controlText);
                        //controlEvents
                        SetControlEvents(myCtl,controlType,control.controlEvents);
                        //add to layout
                        myCtl.setLayoutParams(controlParams);
                        myLayout.addView(myCtl);
                    }
                    if(controlType.equals(String.valueOf(MyEnum.ControlType.TextView))){
                        TextView myCtl = new TextView(context);
                        myCtl.setText(control.controlText);
                        //controlEvents
                        SetControlEvents(myCtl,controlType,control.controlEvents);
                        //add to layout
                        myCtl.setLayoutParams(controlParams);
                        myLayout.addView(myCtl);
                    }
                }

                myLayouts.addView(myLayout);
            }

            //region main layout
            //HorizontalScrollView
            HorizontalScrollView horizontalScrollView=new HorizontalScrollView(context);
            LinearLayout.LayoutParams horizontalScrollViewParam = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);

            //ScrollView
            ScrollView scrollView=new ScrollView(context);
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));

            scrollView.addView(myLayouts, layoutParam);
            horizontalScrollView.addView(scrollView);

            activityThis.addContentView(horizontalScrollView,horizontalScrollViewParam);
            //endregion
        }
    }
    public void SetControlEvents(Object myCtl,String controlType,List<MyControlEvent> events){
        if(events!=null){
            for (MyControlEvent event : events) {
                //ctl type -> TextView, Button
                //ctl event -> Click, LongClick
                if(controlType.equals(String.valueOf(MyEnum.ControlType.TextView))){
                    TextView tv = (TextView) myCtl;
                    if (event.eventName.equals(String.valueOf(MyEnum.EventName.Click))) {
                        tv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                callMyFunction(event);
                            }
                        });
                    }
                    if (event.eventName.equals(String.valueOf(MyEnum.EventName.LongClick))) {
                        tv.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                callMyFunction(event);
                                return false;
                            }
                        });
                    }
                    if (event.eventName.equals(String.valueOf(MyEnum.EventName.TextChange))) {
                        tv.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                callMyFunction(event);
                            }
                            @Override
                            public void afterTextChanged(Editable s) {

                            }
                        });
                    }
                }
                if(controlType.equals(String.valueOf(MyEnum.ControlType.Button))){
                    TextView bt = (TextView) myCtl;
                    if (event.eventName.equals(String.valueOf(MyEnum.EventName.Click))) {
                        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                callMyFunction(event);
                            }
                        });
                    }
                    if (event.eventName.equals(String.valueOf(MyEnum.EventName.LongClick))) {
                        bt.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                callMyFunction(event);
                                return false;
                            }
                        });
                    }
                    if (event.eventName.equals(String.valueOf(MyEnum.EventName.TextChange))) {
                        bt.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }
                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                callMyFunction(event);
                            }
                            @Override
                            public void afterTextChanged(Editable s) {

                            }
                        });
                    }
                }
            }
        }
    }
    public void callMyFunction(MyControlEvent event){
        try{
            MyControlFunc func=event.func;
            String methodName = func.funcName;
            String funcText = func.funcText;
            boolean isBackground = func.isBackground;
            boolean isShowMessage = func.isShowMessage;

            MyFunction obj=new MyFunction();
            Class<?> classObj = obj.getClass();
            Method myFunction = classObj.getDeclaredMethod(methodName, Context.class,String.class,boolean.class,boolean.class);
            myFunction.invoke(obj, myActivityThis,funcText,isBackground,isShowMessage);

        }catch (Exception ignored){}
    }
}
