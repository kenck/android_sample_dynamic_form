package com.example.myform.module;

import java.util.List;

public class MyControlModule {
    public int controlID;
    public String controlName;
    public String controlType;//TextView,Button
    public String controlText;
    public boolean enable;
    public List<MyControlEvent> controlEvents;

    public int getControlID() {
        return controlID;
    }
    public void setControlID(int controlID) {
        this.controlID = controlID;
    }

    public String getControlName() {
        return controlName;
    }
    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    public String getControlType() {
        return controlType;
    }
    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getControlText() {
        return controlText;
    }
    public void setControlText(String controlText) {
        this.controlText = controlText;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    List<MyControlEvent> getControlEvents() {
        return controlEvents;
    }
    void setControlEvents(List<MyControlEvent> controlEvents) {
        this.controlEvents = controlEvents;
    }

}

