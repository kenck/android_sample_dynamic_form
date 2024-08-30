package com.example.myform.module;

import java.util.List;

public class MyLayoutModule {
    public String layoutScroll;//HORIZONTAL or VERTICAL
    public int paddingLeft;
    public int paddingTop;
    public int paddingRight;
    public int paddingBottom;
    public List<MyControlModule> controls;

    public String getLayoutScroll() {
        return layoutScroll;
    }
    public void setLayoutScroll(String layoutScroll) {
        this.layoutScroll = layoutScroll;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }
    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public List<MyControlModule> getControls() {
        return controls;
    }
    public void setControls(List<MyControlModule> controls) {
        this.controls = controls;
    }

}
