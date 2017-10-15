package com.example.donspeer.funwithanagrams;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class HomePage extends AppCompatActivity {

    Button account_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        account_button = (Button) findViewById(R.id.account_button);
        account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SignupPage.class);
                startActivity(intent);
            }
        })  ;

    }
}
