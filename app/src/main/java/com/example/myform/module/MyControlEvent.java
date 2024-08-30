package com.example.myform.module;

public class MyControlEvent{
    public int eventID;
    public String eventName;
    public String eventText;
    public MyControlFunc func;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public MyControlFunc getFunc() {
        return func;
    }

    public void setFunc(MyControlFunc func) {
        this.func = func;
    }
}

