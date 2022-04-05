package com.example.sit305quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity1 extends AppCompatActivity {
    TextView TitleView, QuestionView, WelcomeTextView;
    Button button1, button2, button3, confirmButton;
    String selectedAnswer, name;
    int CurrentProgress = 1;
    int score = 0;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        //Welcome text
        WelcomeTextView = findViewById(R.id.textViewName);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        WelcomeTextView.setText("Welcome " + name + "!");

        //Set up
        TitleView = findViewById(R.id.textView5);
        QuestionView = findViewById(R.id.textView6);
        button1 = findViewById(R.id.button22);
        button2 = findViewById(R.id.button32);
        button3 = findViewById(R.id.button42);
        confirmButton = findViewById(R.id.button52);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(CurrentProgress);
        progressBar.setMax(5);

        //Answer



    }

    public void selectAnswer (View view) {
        button1.setBackgroundResource(R.drawable.answer_text_border);
        button2.setBackgroundResource(R.drawable.answer_text_border);
        button3.setBackgroundResource(R.drawable.answer_text_border);
        Button b = (Button)view;
        selectedAnswer = b.getText().toString();
        b.setBackgroundResource(R.drawable.selected);
    }



    public void onClick (View view) {
        if (confirmButton.getText().equals("Submit")) {
            try {
                if (selectedAnswer.equals(button1.getText().toString())) {
                    button1.setBackgroundResource(R.drawable.correct);
                    score += 1;
                }
                else if (selectedAnswer.equals(button2.getText().toString())) {
                    button1.setBackgroundResource(R.drawable.correct);
                    button2.setBackgroundResource(R.drawable.wrong);
                }
                else if (selectedAnswer.equals(button3.getText().toString())) {
                    button1.setBackgroundResource(R.drawable.correct);
                    button3.setBackgroundResource(R.drawable.wrong);
                }
                confirmButton.setText("Next");
            }
            catch (Exception e){
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            CurrentProgress = CurrentProgress + 1;
            Intent intent = new Intent(this, QuestionActivity2.class);
            intent.putExtra("extraprogress", CurrentProgress);
            intent.putExtra("score", score);
            intent.putExtra("name", name);
            startActivity(intent);
            finish();
        }
    }
}