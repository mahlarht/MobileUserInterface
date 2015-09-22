package com.example.mahla.finalui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Mahla on 9/19/2015.
 */
public class FeedBack extends Activity {


private Button buttonSend;
private EditText textTo;
private EditText editTextSubject;
private EditText Message;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        textTo = (EditText) findViewById(R.id.editTextTo);
        editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        Message = (EditText) findViewById(R.id.messageInfo);
        buttonSend = (Button) findViewById(R.id.btnSubmit);
        textTo.setText("mahla.rahati@gmail.com");


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set null error
                textTo.setError(null);
                editTextSubject.setError(null);
                Message.setError(null);

                boolean has_error = false;
                View focus_view;

                String to = textTo.getText().toString();
                String subject = editTextSubject.getText().toString();
                String message = Message.getText().toString();


                if (TextUtils.isEmpty(subject)) {
                    editTextSubject.setError("لطفا موضوع نظر و انتقاد خود را مشخص کنید");
                    focus_view = editTextSubject;
                    focus_view.requestFocus();
                    has_error = true;
                }


                if (TextUtils.isEmpty(message)) {
                    Message.setError("لطفا توضیحاتی ارائه دهید");
                    focus_view = Message;
                    focus_view.requestFocus();
                    has_error = true;
                }
                write(has_error);


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));


            }


        });


    }

    public void write(boolean has_error) {
        if (!has_error) {
            Intent intent = new Intent(FeedBack.this, MyActivity.class);
            startActivity(intent);
        }

    }
}