package com.example.donspeer.funwithanagrams;


import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


public class HomePage extends AppCompatActivity {

    // sign up button
    Button account_button;
    // action button
    Button play_button;
    // login button
    Button login_button;
    // about button
    Button about_button;

    Switch aSwitch;

    int switchState = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        aSwitch = findViewById(R.id.on_off_mode);
        aSwitch.setChecked(true);
        account_button = findViewById(R.id.account_button); // connecting the sign up button
        play_button = findViewById(R.id.play_button); // connecting the fun with anagrams button
        login_button = findViewById(R.id.login_button); // same thing for login button
        about_button = findViewById(R.id.about);


        // determining on or off switch
        switchState = getIntent().getIntExtra("switch-state", -1);
        if (switchState>=1){
            aSwitch.setChecked(false);
        }


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

        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AboutPage.class);
                startActivity(intent);
            }
        })  ;

    }


}
