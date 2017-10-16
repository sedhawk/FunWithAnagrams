package com.example.donspeer.funwithanagrams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScorePage extends AppCompatActivity {

    Button quit;
    TextView textView23, textView24, textView25;
    int userScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_page);
        quit = (Button) findViewById(R.id.score_quit);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView23.setText(""+ 3);


        userScore = getIntent().getIntExtra("user-score", -1);

        textView24.setText(""+userScore);
        textView25.setText(""+userScore);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        })  ;
    }
}