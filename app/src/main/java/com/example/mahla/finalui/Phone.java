package com.example.mahla.finalui;

/**
 * Created by Mahla on 9/17/2015.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

import java.util.ArrayList;

public class Phone extends Activity {

    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(Phone.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
///



        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<Child> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();


                Intent intent = new Intent(Phone.this, DetailsPhone.class);
                startActivity(intent);
                return false;
            }
        });


        ////


        ExpandList.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();


            }
        });

        ExpandList.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();

            }
        });

    }

    public ArrayList<Group> SetStandardGroups() {

        ArrayList<Group> group_list = new ArrayList<Group>();
        ArrayList<Child> child_list;

        // Setting Group 1
        child_list = new ArrayList<Child>();
        Group gru1 = new Group();
        gru1.setName("Apple");

        Child ch1_1 = new Child();
        ch1_1.setName("Iphone6");
        child_list.add(ch1_1);

        Child ch1_2 = new Child();
        ch1_2.setName("Iphone5");
        child_list.add(ch1_2);

        Child ch1_3 = new Child();
        ch1_3.setName("Iphone4");
        child_list.add(ch1_3);


        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<Child>();
        Group gru2 = new Group();
        gru2.setName("Samsung" );

        Child ch2_1 = new Child();
        ch2_1.setName("Galaxy Grand");
        child_list.add(ch2_1);

        Child ch2_2 = new Child();
        ch2_2.setName("Galaxy Note");
        child_list.add(ch2_2);

        Child ch2_3 = new Child();
        ch2_3.setName("Galaxy Note2");
        child_list.add(ch2_3);

        Child ch2_4 = new Child();
        ch2_4.setName("Galaxy Note3");
        child_list.add(ch2_4);

        gru2.setItems(child_list);

        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);

        return group_list;
    }



}