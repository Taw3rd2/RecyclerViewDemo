package com.waldorfprogramming.recyclerviewdemo.view;

import com.waldorfprogramming.recyclerviewdemo.data.ListItem;

import java.util.List;

/**
 * Created by Zeero on 6/21/2018 at 9:01 PM.
 */
public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResource);

    void setUpAdapterAndView(List<ListItem> listOfData);

}
