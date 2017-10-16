package com.example.donspeer.funwithanagrams;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActionPage extends AppCompatActivity {


    Button quitGame;
    Button submit;
    int tries = 3;
    TextView A1, A2, A3, A4, D1, D2, D3, D4;

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
                tries--;

                if (tries == 0){
                    Intent intent = new Intent(getApplicationContext(), ScorePage.class);
                    startActivity(intent);
                }
                else if (tries == 1){
                    submit.setText("LAST CHANCE DRUNKARD!");
                }
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

                    //if (v.getId() == R.id.A1){
                    //    D1.setText(A1.getText());  //TODO: grab value from dragged box instead
                    //}

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    TextView dragged = (TextView) dragEvent.getLocalState();
                    D1.setText(dragged.getText()); // prints whatever box u put into there

                    //TODO: we need to make a way to print it in the desired box not just D1
                    break;
            }

            return true;
        }
    };
}