package com.example.mahla.finalui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by Mahla on 9/19/2015.
 */
public class HomeNewFragment extends Fragment {
    private EditText Email;
    private EditText subject;
    private EditText group;
    private EditText price;
    private EditText explain;
    private EditText ostan;
    private EditText city;
    private EditText number;
    private ImageView image;
    private Button buttonok;
    private ProgressBar ProgressView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home_new, container, false);


        // image = (ImageView) rootView.findViewById(R.id.imageupload);
        ProgressView = (ProgressBar) rootView.findViewById(R.id.progress);
        subject = (EditText) rootView.findViewById(R.id.subject);
        group = (EditText) rootView.findViewById(R.id.group);
        price = (EditText) rootView.findViewById(R.id.price);
        ostan = (EditText) rootView.findViewById(R.id.ostan);
        city = (EditText) rootView.findViewById(R.id.city);
        number = (EditText) rootView.findViewById(R.id.number);
        explain = (EditText) rootView.findViewById(R.id.explain);
        buttonok = (Button) rootView.findViewById(R.id.buttonok);
        buttonok.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyActivity.class);
                startActivity(intent);
            }
        });

    return rootView;
    }
}