package com.example.mahla.finalui;

/**
 * Created by Mahla on 9/16/2015.
 */

        import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;



/**
 * Created by Mahla on 9/12/2015.
 */
public class SignIn extends Activity{
    private EditText EmailView;
    private EditText PasswordView;
    private ProgressBar ProgressView;
    private Button ButtonView;
    private Button ButtonPreView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EmailView = (EditText) findViewById(R.id.email);
        PasswordView = (EditText) findViewById(R.id.password);
        ProgressView = (ProgressBar) findViewById(R.id.sign_in_progress);
        ButtonView = (Button) findViewById(R.id.sign_in_button);
        ButtonView.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, MyActivity.class);
                startActivity(intent);
            }
        });

        ButtonPreView = (Button) findViewById(R.id.sign_up_pre_button);
        ButtonPreView.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });


    }





}
