package com.waldorfprogramming.recyclerviewdemo.data;

/**
 * Created by Zeeroh on 6/21/2018 at 7:51 PM.
 */
public class ListItem {

    private String dateAndTime;
    private String message;
    private int colorResource;

    public ListItem(String dateAndTime, String message, int colorResource) {
        this.dateAndTime = dateAndTime;
        this.message = message;
        this.colorResource = colorResource;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }
}
