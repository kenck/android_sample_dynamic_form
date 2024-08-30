package com.example.myform.module;

import java.util.List;

public class MyFormModule {
    public int formID;
    public String formName;
    public List<MyLayoutModule> layouts;

    public int getFormID() {
        return formID;
    }
    public void setFormID(int formID) {
        this.formID = formID;
    }

    public String getFormName() {
        return formName;
    }
    public void setFormName(String formName) {
        this.formName = formName;
    }

    public List<MyLayoutModule> getLayouts() {
        return layouts;
    }
    public void setLayouts(List<MyLayoutModule> layouts) {
        this.layouts = layouts;
    }

}

