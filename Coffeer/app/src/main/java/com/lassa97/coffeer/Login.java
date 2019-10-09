package com.lassa97.coffeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
    }

    public void login (View view) {
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
    }
}
