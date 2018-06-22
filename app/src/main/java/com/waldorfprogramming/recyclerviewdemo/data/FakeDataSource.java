package com.waldorfprogramming.recyclerviewdemo.data;

import com.waldorfprogramming.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Zeero on 6/21/2018 at 7:59 PM.
 */
public class FakeDataSource implements DataSourceInterface {

    private static final int SIZE_OF_COLLECTION = 12;

    private final String[] datesAndTimes = {
            "6:30AM 06/01/2017",
            "9:26PM 04/22/2013",
            "2:01PM 12/02/2015",
            "2:43AM 09/07/2018"
    };

    private final String[] messages = {
            "Check out content like Fragmented Podcast to expose yourself to the knowledge, ideas, " +
                    "and opinions of experts in your field",
            "Look at open source projects like Android Arcitecture Blueprints to see how experts" +
                    " design and build Apps",
            "Write lots of code and example apps. Writing good quality code in an efficient manner " +
                    "is a skill to be practiced like no other.",
            "If at first something dosnt make sense, find another explanation. We all learn differently." +
                    " Find an explanation that speaks to you."
    };

    private final int[] colors = {
            R.color.RED,
            R.color.BLUE,
            R.color.GREEN,
            R.color.YELLOW
    };

    public FakeDataSource() {
    }

    @Override
    public List<ListItem> getListOfData() {
        // creates a new blanc arraylist
        ArrayList<ListItem> listOfData = new ArrayList<>();

        // invokes the random generator
        Random random = new Random();

        // builds 12 new ListItems, and adds them to the listOfData
        for(int i = 0; i < 12; i++) {
            int randOne= random.nextInt(4);
            int randTwo= random.nextInt(4);
            int randThree= random.nextInt(4);

            ListItem listItem = new ListItem(
                    datesAndTimes[randOne],
                    messages[randTwo],
                    colors[randThree]
            );

            listOfData.add(listItem);
        };
        return listOfData;
    }
}
