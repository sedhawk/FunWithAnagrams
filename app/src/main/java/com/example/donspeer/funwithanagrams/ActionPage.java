package com.example.donspeer.funwithanagrams;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import org.w3c.dom.Text;

public class ActionPage extends AppCompatActivity {


    Button quitGame;
    Button submit;
    int tries = 2;
    int level = 1;
    int score = 0;
    //String level1String = "IRDA";
    //String level2String = "OLES";
    //String level3String = "SIHT";
    TextView A1, A2, A3, A4, D1, D2, D3, D4, level_view, token_total;
    String[] level1Array = {"ARID", "RAID"};
    String[] level2Array = {"LOSE", "SLOE","SOLE"};
    String[] level3Array = {"HIST", "SHIT", "SITH", "THIS"};
    Random r = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_page);

        // grab login and new account information
        EditText loginName          = (EditText) findViewById(R.id.user_name);
        EditText getPassword        = (EditText) findViewById(R.id.password);
        EditText getNewName         = (EditText) findViewById(R.id.create_name);
        EditText getNewPassword     = (EditText) findViewById(R.id.create_password);
        EditText getVerifyPassword  = (EditText) findViewById(R.id.verify_password);

        // store login and new account info into variable
        /*String storeName            = loginName.getText().toString();
        String storePassword        = getPassword.getText().toString();
        String storeNewName         = getNewName.getText().toString();
        String storeNewPassword     = getNewPassword.getText().toString();
        String storeVerifyPassword  = getVerifyPassword.getText().toString();*/


        quitGame    = (Button) findViewById(R.id.action_quit);
        submit      = (Button) findViewById(R.id.submit_button);
        level_view  = findViewById(R.id.level_view);
        token_total = findViewById(R.id.token_total);

        connector();
        token_total.setText("" + score);

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
                if (level <=3){
                    level++;
                    connector();


                }

                 if (level > 3)
                    level = 3;

                level_view.setText("Level " + level);
                token_total.setText("" + score);

                if (tries == 0){
                    submit.setText("LAST ONE DRUNKARD!");
                }
                else if (tries <= -1){
                    Intent intent = new Intent(getApplicationContext(), ScorePage.class);
                    intent.putExtra("user-score",score);
                    startActivity(intent);
                }


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


                    break;
            }

            return true;
        }
    };

    public static void main(String[] args){
        // to test methods functionality
        //Random r = new Random();
       // System.out.println(genRandomNum(r,"RAID",4));

    }


    public static String genRandomNum(Random rng, String characters, int length){
        // shuffles the word
        char[] text = characters.toCharArray();
        for( int i=0 ; i<text.length ; i++ ){
            int j = rng.nextInt(text.length);
            char temp = text[i]; text[i] = text[j];  text[j] = temp;
        }
        return new String(text);
    }

    public void fillBoxes (TextView[] boxArray, String word){
        // fills the boxes
       for (int i = 0; i < boxArray.length; i++){
            boxArray[i].setText("" + word.charAt(i));
            D1.setText("");
            D2.setText("");
            D3.setText("");
            D4.setText("");
        }

    }


    public void checkBoxes(TextView[] choiceAr, String[] answerAr){
        // checks the user answer
        String userChoice = "";
        for (int i = 0; i < choiceAr.length; i++){
            userChoice += choiceAr[i].getText();
        }

        for (int x = 0; x <answerAr.length; x++){
            if(answerAr[x].equals(userChoice)){
                score++;
            }
        }
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
        TextView[] answerArray = {D1, D2, D3, D4};

        // if statements that fill the boxes then in the other case checks the answers
        if (level == 1){

            fillBoxes(boxArray, genRandomNum(r,level1Array[0],4));


        } else if (level == 2){
            checkBoxes(answerArray, level1Array);
            fillBoxes(boxArray,genRandomNum(r,level2Array[0],4));



        } else if (level == 3){

            checkBoxes(answerArray, level2Array);
            fillBoxes(boxArray,genRandomNum(r,level3Array[0],4));

        } else if (level == 4) {
            checkBoxes(answerArray, level3Array);
        }

    }

}