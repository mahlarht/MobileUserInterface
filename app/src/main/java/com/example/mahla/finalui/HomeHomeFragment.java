package com.example.mahla.finalui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class HomeHomeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home_home, container, false);


        GridView gridview = (GridView) rootView.findViewById(R.id.gridView4);
        gridview.setAdapter(new ImageAdapter(rootView.getContext()));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Log.d(String.valueOf(position), "iiasad:");
                Log.d("Posi:", String.valueOf(position));


                switch (position) {
                    case 0:
                        Intent i = new Intent(getActivity(), Phone.class);
                        // Pass image index
                        i.putExtra("id", position);
                        startActivity(i);
                        break;

                    case 1:
                        Intent i1 = new Intent(getActivity(), SignIn.class);
                        // Pass image index
                        i1.putExtra("id", position);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(getActivity(), SignIn.class);
                        // Pass image index
                        i2.putExtra("id", position);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(getActivity(), SignIn.class);
                        // Pass image index
                        i3.putExtra("id", position);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(getActivity(), SignIn.class);
                        // Pass image index
                        i4.putExtra("id", position);
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(getActivity(), SignIn.class);
                        // Pass image index
                        i5.putExtra("id", position);
                        startActivity(i5);
                        break;

                    default:

                        break;

                }

                // Send intent to SingleViewActivity


            }
        });


        return rootView;
    }
}




