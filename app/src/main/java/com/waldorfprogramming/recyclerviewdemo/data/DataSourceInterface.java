package com.waldorfprogramming.recyclerviewdemo.data;

import java.util.List;

/**
 * Created by Zeero on 6/21/2018 at 8:01 PM.
 * This is a contract between classes that dictates how they can talk to each other
 * without giving implementation details.
 */
public interface DataSourceInterface {

    List<ListItem> getListOfData();
}
