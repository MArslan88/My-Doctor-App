package com.mhdarslan.mydoctorapp;

public class Word {
    private String mHeading;
    private String mDesc;

    public Word(String Heading, String Desc) {
        this.mHeading = Heading;
        this.mDesc = Desc;
    }

    public String getmHeading() {
        return mHeading;
    }

    public String getmDesc() {
        return mDesc;
    }
}
