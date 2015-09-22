package com.example.mahla.finalui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

import static com.example.mahla.finalui.R.drawable;
import static com.example.mahla.finalui.R.id;
import static com.example.mahla.finalui.R.layout;

public class DetailsPhone extends Activity {
    // more efficient than HashMap for mapping integers to objects
    SparseArray<Group1> groups = new SparseArray<Group1>();
    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private Button ButtonView;
    private ExpandableListView ExpandList;


    //the images to display
    Integer[] imageIDs = {
            drawable.one,
            drawable.two,
            drawable.three,
            drawable.four,
            drawable.five,
            drawable.six,
            drawable.seven
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.details_phone);

        ///

        // Note that Gallery view is deprecated in Android 4.1---
        Gallery gallery = (Gallery) findViewById(id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position,long id)
            {
                //Toast.makeText(getBaseContext(),"pic" + (position + 1) + " selected",
                //      Toast.LENGTH_SHORT).show();
                // display the images selected
                ImageView imageView = (ImageView) findViewById(R.id.image1);
                imageView.setImageResource(imageIDs[position]);
                ButtonView = (Button) findViewById(R.id.button3);
                ButtonView.setOnClickListener(new View.OnClickListener()

                {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DetailsPhone.this, MyActivity.class);
                        startActivity(intent);
                    }
                });


            }
        });

        ///
        ExpandList = (ExpandableListView) findViewById(id.ListView);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(DetailsPhone.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<Child> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();



                return false;
            }


        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();


            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

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
        gru1.setName("مشخصات کلی");

        Child ch1_1 = new Child();
        ch1_1.setName("دو سیم کارته");
        child_list.add(ch1_1);

        Child ch1_2 = new Child();
        ch1_2.setName("سیم کارت میکرو");
        child_list.add(ch1_2);

        Child ch1_3 = new Child();
        ch1_3.setName("وزن 134 گرم");
        child_list.add(ch1_3);


        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<Child>();
        Group gru2 = new Group();
        gru2.setName("پردازنده");

        Child ch2_1 = new Child();
        ch2_1.setName("Quad core cortex-A7 CPU ");
        child_list.add(ch2_1);

        Child ch2_2 = new Child();
        ch2_2.setName(" پردازنده 32بیت");
        child_list.add(ch2_2);

        Child ch2_3 = new Child();
        ch2_3.setName("فرکانس 1.2 گیگاهرتز ");
        child_list.add(ch2_3);

        Child ch2_4 = new Child();
        ch2_4.setName(" پردازنده گرافیکی adreno 305");
        child_list.add(ch2_4);

        gru2.setItems(child_list);

        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);

        return group_list;
    }

////me

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;
            // sets a grey background; wraps around the images

            TypedArray a =obtainStyledAttributes(R.styleable.MyGallery_android_galleryItemBackground);
            //itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground);
            a.recycle();
        }
        // returns the number of images
        public int getCount() {
            return imageIDs.length;
        }
        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }
        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }
        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }

////
}
