package com.example.mahla.finalui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

/**
 * Created by Mahla on 9/17/2015.
 */
public class HomeNewsFeedFragment  extends Fragment {
    private SearchView searchView;
    private View rootView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            saveInstanceState) {
        // setHasOptionsMenu(true);
        rootView = inflater.inflate(R.layout.fragment_news_feed, container, false);

        searchView =
                (SearchView) rootView.findViewById(R.id.search);

        return rootView;
    }

}




