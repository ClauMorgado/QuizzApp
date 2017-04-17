package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.question_2_a1;

public class MainActivity extends AppCompatActivity {

    // Variables for the answers of the quiz
    CheckBox checkbox_q3_a1;
    CheckBox checkbox_q3_a2;
    CheckBox checkbox_q3_a3;
    CheckBox checkbox_q3_a4;
    CheckBox checkbox_q3_a5;
    CheckBox checkbox_q3_a6;
    CheckBox checkbox_q5_a1;
    CheckBox checkbox_q5_a2;
    CheckBox checkbox_q5_a3;
    CheckBox checkbox_q5_a4;
    CheckBox checkbox_q5_a5;
    EditText add_name;
    EditText text_question1;
    EditText text_question4;
    RadioGroup radioGroupQ2;
    RadioGroup radioGroupQ6;
    int score = 0;
    String q1 = "Europe";
    String q4 = "crater";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitAnswers(View v) {

        // Add the name of the player
        add_name = (EditText) findViewById(R.id.player_name);
        String add_name_player = add_name.getText().toString();

        // Check answer for question 1
        text_question1 = (EditText) findViewById(R.id.question_1_a1);
        String solutionQuestion1 = text_question1.getText().toString();
        if (solutionQuestion1.equalsIgnoreCase(q1)) {
            score += 10;
        }

        // Check answer for question 2
        radioGroupQ2 = (RadioGroup) findViewById(R.id.question_2_radiobox);
        int solutionQuestion2 = radioGroupQ2.getCheckedRadioButtonId();
        if (solutionQuestion2 == question_2_a1) {
            score += 10;
        }

        // Check answer for question 3
        checkbox_q3_a1 = (CheckBox) findViewById(R.id.checkbox_q3_a1);
        checkbox_q3_a2 = (CheckBox) findViewById(R.id.checkbox_q3_a2);
        checkbox_q3_a3 = (CheckBox) findViewById(R.id.checkbox_q3_a3);
        checkbox_q3_a4 = (CheckBox) findViewById(R.id.checkbox_q3_a4);
        checkbox_q3_a5 = (CheckBox) findViewById(R.id.checkbox_q3_a5);
        checkbox_q3_a6 = (CheckBox) findViewById(R.id.checkbox_q3_a6);
        if (checkbox_q3_a2.isChecked() && checkbox_q3_a4.isChecked() && checkbox_q3_a5.isChecked() &&
                !checkbox_q3_a1.isChecked() && !checkbox_q3_a3.isChecked() && !checkbox_q3_a6.isChecked()) {
            score += 10;
        }

        // Check answer for question 4
        text_question4 = (EditText) findViewById(R.id.question_4_a1);
        String solutionQuestion4 = text_question4.getText().toString();
        if (solutionQuestion4.equalsIgnoreCase(q4)) {
            score += 10;
        }

        // Check answer for question 5
        checkbox_q5_a1 = (CheckBox) findViewById(R.id.checkbox_q5_a1);
        checkbox_q5_a2 = (CheckBox) findViewById(R.id.checkbox_q5_a2);
        checkbox_q5_a3 = (CheckBox) findViewById(R.id.checkbox_q5_a3);
        checkbox_q5_a4 = (CheckBox) findViewById(R.id.checkbox_q5_a4);
        checkbox_q5_a5 = (CheckBox) findViewById(R.id.checkbox_q5_a5);
        if (checkbox_q5_a4.isChecked() && checkbox_q5_a5.isChecked() &&
                !checkbox_q5_a1.isChecked() && !checkbox_q5_a2.isChecked() && !checkbox_q5_a3.isChecked()) {
            score += 10;
        }

        // Check answer for question 6
        radioGroupQ6 = (RadioGroup) findViewById(R.id.question_6_radiobox);
        int solutionQuestion6 = radioGroupQ6.getCheckedRadioButtonId();
        if (solutionQuestion6 == R.id.question_6_a4) {
            score += 10;
        }

        // Toast message with player name and score
        Context context = getApplicationContext();
        CharSequence text = "Name: " + add_name_player + "\nScore: " + score;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    public void resetScore(View v) {

        // Clear name information
        add_name.setText("");

        // Clear answer for question 1
        text_question1.setText("");

        // Clear answer for question 2
        radioGroupQ2.clearCheck();

        // Clear answer for question 3
        checkbox_q3_a1.setChecked(false);
        checkbox_q3_a2.setChecked(false);
        checkbox_q3_a3.setChecked(false);
        checkbox_q3_a4.setChecked(false);
        checkbox_q3_a5.setChecked(false);
        checkbox_q3_a6.setChecked(false);

        // Clear answer for question 4
        text_question4.setText("");

        // Clear answer for question 5
        checkbox_q5_a1.setChecked(false);
        checkbox_q5_a2.setChecked(false);
        checkbox_q5_a3.setChecked(false);
        checkbox_q5_a4.setChecked(false);
        checkbox_q5_a5.setChecked(false);

        // Clear answer for question 6
        radioGroupQ6.clearCheck();

        // Reset score for all questions
        score = 0;
    }

}


