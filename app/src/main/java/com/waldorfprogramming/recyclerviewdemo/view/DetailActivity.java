package com.waldorfprogramming.recyclerviewdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.waldorfprogramming.recyclerviewdemo.R;

/**
 * Created by Zeero on 6/21/2018 at 6:23 PM.
 */
public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private TextView dateAndTime;
    private TextView message;
    private View coloredBackground;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        String dateAndTimeExtra = i.getStringExtra(EXTRA_DATE_AND_TIME);
        String messageExtra = i.getStringExtra(EXTRA_MESSAGE);
        int colorResourceExtra = i.getIntExtra(EXTRA_COLOR, 0);

        dateAndTime = (TextView) findViewById(R.id.lbl_date_and_time_header);
        dateAndTime.setText(dateAndTimeExtra);

        message = (TextView) findViewById(R.id.lbl_message_body);
        message.setText(messageExtra);

        coloredBackground = findViewById(R.id.cont_colored_background);
        coloredBackground.setBackgroundColor(ContextCompat.getColor(this, colorResourceExtra));
    }
}
