package com.example.mahla.finalui;

/**
 * Created by Mahla on 9/19/2015.
 */


        import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class ChangePassword extends Activity {
    private EditText EcurrentPassView;
    private EditText EnewPassView;
    private EditText EconfirmPassView;
    private Button ButtonView;
    private ProgressBar ProgressView;
    private int password_size = 2; // dynamic
    private boolean has_error = false;
    private Activity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Intent intent = getIntent();

        EcurrentPassView = (EditText) findViewById(R.id.EcurrentPassword);
        EnewPassView = (EditText) findViewById(R.id.EnewPassword);
        EconfirmPassView = (EditText) findViewById(R.id.EconfirmPassword);
        ProgressView = (ProgressBar) findViewById(R.id.change_password_progress);
        ButtonView = (Button) findViewById(R.id.change_password_button);


    }


    public void change_password(View view) {


        ButtonView.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view) {

                //set null error
                EcurrentPassView.setError(null);
                EnewPassView.setError(null);
                EnewPassView.setError(null);

                //set variable
                boolean has_error = false;
                String EcurrentPassword = EcurrentPassView.getText().toString();
                String EnewPassword = EnewPassView.getText().toString();
                String EconfirmPassword = EconfirmPassView.getText().toString();

                View focus_view;


                // check if Edit texts are Empty

                if (TextUtils.isEmpty(EcurrentPassword)) {
                    EcurrentPassView.setError("گذرواژه فعلی را وارد کنید");
                    focus_view = EcurrentPassView;
                    focus_view.requestFocus();
                    has_error = true;


                }
                if (TextUtils.isEmpty(EnewPassword)) {
                    EnewPassView.setError("گذروارژه جدید را وارد کنید");
                    focus_view = EnewPassView;
                    focus_view.requestFocus();
                    has_error = true;


                }
                if (TextUtils.isEmpty(EconfirmPassword)) {
                    EconfirmPassView.setError("گذرواژه جدید را دوباره وارد کنید");
                    focus_view = EconfirmPassView;
                    focus_view.requestFocus();
                    has_error = true;
                }
                if (!EnewPassword.equals(EconfirmPassword)) {
                    Log.d("passwrd1", EnewPassword);
                    Log.d("passwrd2", EconfirmPassword);
                    EconfirmPassView.setError("گذر واژه را اشتباه وارد کردید");
                    focus_view = EconfirmPassView;
                    focus_view.requestFocus();
                    has_error = true;


                }

                change_password(has_error);


            }

        });


    }
    public void change_password(boolean has_error) {
        if (!has_error) {
            Intent intent = new Intent(ChangePassword.this, MyActivity.class);

            startActivity(intent);
        }
    }
}


