package com.example.mahla.finalui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mahla on 9/19/2015.
 */

public class About extends Activity {
    private Button ButtonView;
    private Button ButtonView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        ButtonView.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(About.this, Help.class);
                startActivity(intent);
            }
        });

        ButtonView1.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(About.this, MyActivity.class);
                startActivity(intent);
            }
        });
    }
}
