package com.sourcey.TimeTracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {
    private EditText mTextUserName;
    private EditText mTextPassword;
    public String user_name;
    public String pass_word;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTextUserName = (EditText) findViewById(R.id.input_email);
        mTextPassword = (EditText) findViewById(R.id.input_password);
        Button mButtonLogin = (Button) findViewById(R.id.btn_login);


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                user_name = mTextUserName.getText().toString();
                pass_word = mTextPassword.getText().toString();

                Intent goToNextActivity = new Intent(getApplicationContext(), MainActivity.class);
                Bundle b = new Bundle ();
                b.putString("Username", user_name);
                b.putString("Password",pass_word);
                goToNextActivity.putExtras(b);
                startActivity(goToNextActivity);
            }
        });
    }
}

