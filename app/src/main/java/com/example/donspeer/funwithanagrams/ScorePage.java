package com.example.donspeer.funwithanagrams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScorePage extends AppCompatActivity {

    Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_page);
        quit = (Button) findViewById(R.id.score_quit);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        })  ;
    }
}