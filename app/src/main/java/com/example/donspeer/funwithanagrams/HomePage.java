package com.example.donspeer.funwithanagrams;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomePage extends AppCompatActivity {

    // sign up button
    Button account_button;
    // action button
    Button play_button;
    // login button
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        account_button = (Button) findViewById(R.id.account_button); // connecting the sign up button
        play_button = (Button) findViewById(R.id.play_button); // connecting the fun with anagrams button
        login_button = (Button) findViewById(R.id.login_button); // same thing for login button





        // user clicking then going to sign up page
        account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SignupPage.class);
                startActivity(intent);
            }
        })  ;
        // user clicking on play button then going to action page
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActionPage.class);
                startActivity(intent);
            }
        })  ;
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        })  ;


    }
}
