package com.waldorfprogramming.recyclerviewdemo.logic;

import com.waldorfprogramming.recyclerviewdemo.data.DataSourceInterface;
import com.waldorfprogramming.recyclerviewdemo.data.ListItem;
import com.waldorfprogramming.recyclerviewdemo.view.ViewInterface;

/**
 * Created by Zeero on 6/21/2018 at 9:05 PM.
 */
public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );
    }

    public void onListItemClicked(ListItem testItem) {
        view.startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }
}
