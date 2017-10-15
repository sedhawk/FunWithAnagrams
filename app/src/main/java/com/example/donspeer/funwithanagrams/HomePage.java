package com.example.donspeer.funwithanagrams;


import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
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

    TextView A1, A2, A3, A4, D1, D2, D3, D4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        account_button = (Button) findViewById(R.id.account_button); // connecting the sign up button
        play_button = (Button) findViewById(R.id.play_button); // connecting the fun with anagrams button
        login_button = (Button) findViewById(R.id.login_button); // same thing for login button
        about_button = (Button) findViewById(R.id.about);


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

        // sources to drag
        A1 = findViewById(R.id.A1);
        A2 = findViewById(R.id.A2);
        A3 = findViewById(R.id.A3);
        A4 = findViewById(R.id.A4);

        // targets
        D1 = findViewById(R.id.D1);
        D2 = findViewById(R.id.D2);
        D3 = findViewById(R.id.D3);
        D4 = findViewById(R.id.D4);

        // make connection from sources to longClickListener
        A1.setOnLongClickListener(longClickListener);
        A2.setOnLongClickListener(longClickListener);
        A3.setOnLongClickListener(longClickListener);
        A4.setOnLongClickListener(longClickListener);

        // set targets for on drag listener
        D1.setOnDragListener(dragListener);
        D2.setOnDragListener(dragListener);
        D3.setOnDragListener(dragListener);
        D4.setOnDragListener(dragListener);

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText(".", ".");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, myShadowBuilder, view, 0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int dEvent = dragEvent.getAction();

            switch (dEvent){
                case DragEvent.ACTION_DRAG_ENTERED:     //Tells us which view is dragged
                    final View v = (View) dragEvent.getLocalState();

                    if (v.getId() == R.id.A1){
                        D1.setText("?");  //TODO: grab value from dragged box instead
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    break;
            }

            return true;
        }
    };
}
