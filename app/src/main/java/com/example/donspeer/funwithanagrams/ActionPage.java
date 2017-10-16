package com.example.donspeer.funwithanagrams;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import org.w3c.dom.Text;

public class ActionPage extends AppCompatActivity {


    Button quitGame;
    Button submit;
    int tries = 3;
    int level = 1;
    //String level1String = "IRDA";
    //String level2String = "OLES";
    //String level3String = "SIHT";
    TextView A1, A2, A3, A4, D1, D2, D3, D4, level_view;
    String[] level1Array = {"ARID", "RAID"};
    String[] level2Array = {"LOSE", "SLOE","SOLE"};
    String[] level3Array = {"HIST", "SHIT", "SITH", "THIS"};
    Random r = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_page);



        quitGame = (Button) findViewById(R.id.action_quit);
        submit = (Button) findViewById(R.id.submit_button);
        level_view = findViewById(R.id.level_view);

        connector();

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
                level++;
                level_view.setText("Level " + level);
                if (tries == 0){
                    Intent intent = new Intent(getApplicationContext(), ScorePage.class);
                    startActivity(intent);
                }
                else if (tries == 1){
                    submit.setText("LAST CHANCE DRUNKARD!");
                }
                connector();

            }
        })  ;


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
            final View v = (View) dragEvent.getLocalState();

            switch (dEvent){
                case DragEvent.ACTION_DRAG_ENTERED:     //Tells us which view is dragged

                    /*if (v.getId() == R.id.A1){
                        D1.setText(A1.getText());  //TODO: grab value from dragged box instead
                    }
                    else if (v.getId() == R.id.A2) {
                        D1.setText("N");
                    }
                    else if (v.getId() == R.id.A3) {
                        D1.setText("N");
                    }
                    else if (v.getId() == R.id.A4) {
                        D1.setText("N");
                    }*/

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    TextView dragged = (TextView) dragEvent.getLocalState();
                    if (v.getId() == R.id.A1 && view.getId() == R.id.D1) {
                        D1.setText(dragged.getText()); // prints whatever box u put into there
                    } else if (v.getId() == R.id.A1 && view.getId() == R.id.D2) {
                        D2.setText(dragged.getText());
                    } else if (v.getId() == R.id.A1 && view.getId() == R.id.D3) {
                        D3.setText(dragged.getText());
                    } else if (v.getId() == R.id.A1 && view.getId() == R.id.D4) {
                        D4.setText(dragged.getText());
                    } else if (v.getId() == R.id.A2 && view.getId() == R.id.D1) {
                        D1.setText(dragged.getText());
                    } else if (v.getId() == R.id.A2 && view.getId() == R.id.D2) {
                        D2.setText(dragged.getText());
                    } else if (v.getId() == R.id.A2 && view.getId() == R.id.D3) {
                        D3.setText(dragged.getText());
                    } else if (v.getId() == R.id.A2 && view.getId() == R.id.D4) {
                        D4.setText(dragged.getText());
                    } else if (v.getId() == R.id.A3 && view.getId() == R.id.D1) {
                        D1.setText(dragged.getText());
                    } else if (v.getId() == R.id.A3 && view.getId() == R.id.D2) {
                        D2.setText(dragged.getText());
                    } else if (v.getId() == R.id.A3 && view.getId() == R.id.D3) {
                        D3.setText(dragged.getText());
                    } else if (v.getId() == R.id.A3 && view.getId() == R.id.D4) {
                        D4.setText(dragged.getText());
                    } else if (v.getId() == R.id.A4 && view.getId() == R.id.D1) {
                        D1.setText(dragged.getText());
                    } else if (v.getId() == R.id.A4 && view.getId() == R.id.D2) {
                        D2.setText(dragged.getText());
                    } else if (v.getId() == R.id.A4 && view.getId() == R.id.D3) {
                        D3.setText(dragged.getText());
                    } else if (v.getId() == R.id.A4 && view.getId() == R.id.D4) {
                        D4.setText(dragged.getText());
                    }


                    //TODO: we need to make a way to print it in the desired box not just D1
                    break;
            }

            return true;
        }
    };

    public static String genRandomNum(Random rng, String characters, int length){
        char[] text = new char[length];
        for (int i = 0; i<length;i++){
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public void fillBoxes (TextView[] boxArray, String word){
        //   for(int i = 0; i < boxArray.length;i++){
        //     boxArray[i].setText(level1Word.charAt(i));
        //}
       for (int i = 0; i < boxArray.length-1; i++){
            boxArray[i].setText("" + word.charAt(i));
        }
        /*
        boxArray[0].setText(word.charAt(0));
        boxArray[1].setText(word.charAt(1));
        boxArray[2].setText(word.charAt(2));
        boxArray[3].setText(word.charAt(3));
        */
    }

    public void connector () {

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

        TextView[] boxArray = {A1, A2, A3, A4};

        //String level1Word = level1Array[1];
        //level1Word = genRandomNum(r,level1Word,4);
        if (level == 1){
          //  fillBoxes(boxArray, level1Word);
            A1.setText("I");
            A2.setText("R");
            A3.setText("D");
            A4.setText("A");
        } else if (level == 2){
            A1.setText("O");
            A2.setText("L");
            A3.setText("E");
            A4.setText("S");
        } else if (level == 3){
           /* A1.setText("S");
            A2.setText("I");
            A3.setText("H");
            A4.setText("T");
            A1.setText("" + level3Array[0].charAt(0));
            A2.setText("" + level3Array[0].charAt(1));
            A3.setText("" + level3Array[0].charAt(2));
            A4.setText("" + level3Array[0].charAt(3));
            */
           fillBoxes(boxArray,level1Array[0]);
        }

    }

}