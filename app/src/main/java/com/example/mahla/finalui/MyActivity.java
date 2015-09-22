package com.example.mahla.finalui;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;


public class MyActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public static final String EXTRA_MESSAGE = "message";
    public static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Bundle msg;
    private String mTitle;
    private Context context;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);



        context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }





    @Override
    public void onNavigationDrawerItemSelected(int position) {

        Fragment objfrag = null;

        switch (position) {

            case 0:
                mTitle = getString(R.string.action_home);
                objfrag = new HomeHomeFragment();
                objfrag.setArguments(msg);
                break;
            case 1:
                mTitle = getString(R.string.action_newsFeed);
                objfrag = new HomeNewsFeedFragment();
                objfrag.setArguments(msg);
                break;
            case 2:
                mTitle = getString(R.string.action_new);
                objfrag = new HomeNewFragment();
                objfrag.setArguments(msg);
                break;
            case 3:
                mTitle = getString(R.string.action_settings);
                objfrag = new HomeSettingFragment();
                objfrag.setArguments(msg);
                break;



        }
        // update the main content by replacing fragments

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, objfrag)
                .commit();

    }


    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.home_profile_menu, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("می خواهید از برنامه خارج شوید؟");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // controller.deleteMe();

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //  finish();
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }
}
