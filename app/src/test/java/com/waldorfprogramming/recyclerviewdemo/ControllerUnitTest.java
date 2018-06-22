package com.waldorfprogramming.recyclerviewdemo;

import com.waldorfprogramming.recyclerviewdemo.data.DataSourceInterface;
import com.waldorfprogramming.recyclerviewdemo.data.ListItem;
import com.waldorfprogramming.recyclerviewdemo.logic.Controller;
import com.waldorfprogramming.recyclerviewdemo.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {



    // this is a built Mock up to test with
    @Mock
    DataSourceInterface dataSource;

    // this is another built Mock up to test with
    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem testItem = new ListItem(
            "2:43AM 09/07/2018",
            "Write lots of code and example apps",
            R.color.RED
    );

    @Before // sets up the test data
    public void setUpTest () {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);

    }

    @Test // the actual test
    public void onGetListDataSuccessful() {
        // set up any data we need for the test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        // Set up our Mochs to return the data we want
        Mockito.when(dataSource.getListOfData())
                .thenReturn(listOfData);

        // call the method(unit) we are testing
        controller.getListFromDataSource();

        // check how the tested class responds to the data it receives
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked() {
        controller.onListItemClicked(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }

}