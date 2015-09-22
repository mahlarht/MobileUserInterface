package com.example.mahla.finalui;

/**
 * Created by Mahla on 9/16/2015.
 */

        import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;



public class SignUp extends Activity {
    private EditText EmailView;
    private EditText PasswordView;
    private EditText RePasswordView;
    private ProgressBar ProgressView;
    private Button ButtonView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EmailView = (EditText) findViewById(R.id.email);
        PasswordView = (EditText) findViewById(R.id.password);
        RePasswordView = (EditText) findViewById(R.id.re_password);
        ProgressView = (ProgressBar) findViewById(R.id.sign_up_progress);
        ButtonView = (Button) findViewById(R.id.sign_up_button);
        ButtonView.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, About.class);
                startActivity(intent);
            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

