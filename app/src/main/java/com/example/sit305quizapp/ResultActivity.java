package com.example.sit305quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView Congrats, ScoreView;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Congrats = findViewById(R.id.textView2);
        ScoreView = findViewById(R.id.textView4);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        Congrats.setText("Congratulations " + name + "!");
        int score = intent.getIntExtra("score", 0);
        ScoreView.setText(String.valueOf(score) + "/5");
    }

    public void finishClick(View view) {
        Button b = (Button)view;
        if (b.getText().toString().equals("Take New Quiz")) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
            finish();
        }
        else {
            finish();
        }
    }
}