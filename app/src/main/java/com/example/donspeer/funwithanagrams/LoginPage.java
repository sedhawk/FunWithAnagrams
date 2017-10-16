package com.example.donspeer.funwithanagrams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginPage extends AppCompatActivity {

    Button login;
    TextView username;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        login = findViewById(R.id.login);

        username = findViewById(R.id.user_name);
        password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                intent.putExtra("switch-state", 1);
                startActivity(intent);
            }
        })  ;
    }
}
