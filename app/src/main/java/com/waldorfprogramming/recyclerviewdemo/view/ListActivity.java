package com.waldorfprogramming.recyclerviewdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waldorfprogramming.recyclerviewdemo.R;
import com.waldorfprogramming.recyclerviewdemo.data.FakeDataSource;
import com.waldorfprogramming.recyclerviewdemo.data.ListItem;
import com.waldorfprogramming.recyclerviewdemo.logic.Controller;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface{

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        // this is Dependency Injection
        controller = new Controller(this, new FakeDataSource());

    }

    @Override
    public void startDetailActivity(String dateAndTime, String message, int colorResource) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(EXTRA_DATE_AND_TIME, dateAndTime);
        i.putExtra(EXTRA_MESSAGE, message);
        i.putExtra(EXTRA_COLOR, colorResource);

        startActivity(i);
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }






    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            ListItem currentItem = listOfData.get(position);

            holder.coloredCircle.setBackgroundResource(currentItem.getColorResource());
            holder.message.setText(currentItem.getMessage());
            holder.dateAndTime.setText(currentItem.getDateAndTime());

        }

        // helps the adapter decide how many items it wall need to manage
        @Override
        public int getItemCount() {
            return listOfData.size();
        }











        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private View coloredCircle;
            private TextView dateAndTime;
            private TextView message;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);

                this.coloredCircle = itemView.findViewById(R.id.imv_list_item_circle);
                this.dateAndTime = (TextView) itemView.findViewById(R.id.lbl_date_and_time);
                this.message = (TextView) itemView.findViewById(R.id.lbl_message);
                this.container = itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onListItemClicked(listItem);

            }
        }
    }
}
