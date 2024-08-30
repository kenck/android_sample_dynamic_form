package com.example.myform.module;

public class MyControlFunc{
    public int funcID;
    public String funcName;
    public String funcText;
    public boolean isBackground;// run in background or foreground
    public boolean isShowMessage;//show message when finish task

    public int getFuncID() {
        return funcID;
    }

    public void setFuncID(int funcID) {
        this.funcID = funcID;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncText() {
        return funcText;
    }

    public void setFuncText(String funcText) {
        this.funcText = funcText;
    }

    public boolean isBackground() {
        return this.isBackground;
    }

    public void setBackground(boolean background) {
        isBackground = background;
    }

    public boolean isShowMessage() {
        return this.isShowMessage;
    }

    public void setShowMessage(boolean showMessage) {
        isShowMessage = showMessage;
    }
}
