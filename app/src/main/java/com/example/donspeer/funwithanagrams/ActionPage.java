package com.example.donspeer.funwithanagrams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActionPage extends AppCompatActivity {


    Button quitGame;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_page);

        quitGame = (Button) findViewById(R.id.action_quit);
        submit = (Button) findViewById(R.id.submit_button);

        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        })  ;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checks the user answer then adds it to the score if right

            }
        })  ;


    }
}