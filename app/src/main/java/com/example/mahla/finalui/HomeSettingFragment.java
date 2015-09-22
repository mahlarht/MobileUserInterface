package com.example.mahla.finalui;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Mahla on 9/16/2015.
 */


public class HomeSettingFragment extends Fragment {


    private Button changePassword;
    private Button aboutUs;
    private Button signOut;
    private Button feedBack;
    private View rootView;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home_setting, container, false);
        changePassword = (Button) rootView.findViewById(R.id.ChangePasswordButton);
        changePassword.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view) {
                boolean has_error = false;


                changePassword(has_error);

            }
        });


        feedBack = (Button) rootView.findViewById(R.id.FeedBackButton);
        feedBack.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view) {
                boolean has_error = false;


                feedback(has_error);

            }
        });
        aboutUs = (Button) rootView.findViewById(R.id.aboutUs_button);
        aboutUs.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view) {
                boolean has_error = false;


                about(has_error);

            }
        });

        signOut = (Button) rootView.findViewById(R.id.signOut_button);
        signOut.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view) {

                Log.d("CLick On SIgnOUt ", "click");
                boolean has_error = false;


                signOut(has_error);

            }
        });




        return rootView;
    }
    private void changePassword(boolean view) {
        Intent intent;
        intent = new Intent(getActivity(), ChangePassword.class);
        startActivity(intent);


    }

    public void feedback(boolean view) {

        Intent intent = new Intent(getActivity(), FeedBack.class);
        startActivity(intent);

    }

    public void about(boolean view) {

        Intent intent = new Intent(getActivity(), About.class);
        startActivity(intent);

    }


    public void signOut(boolean view)
    {




        //  RegID = data.getString("regID");

        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setMessage("می خواهید از برنامه خارج شوید؟");
        builder.setCancelable(false);
        builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(getActivity(), SignIn.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().finish();
                startActivity(intent);








            }
        }).setNegativeButton("خیر", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
