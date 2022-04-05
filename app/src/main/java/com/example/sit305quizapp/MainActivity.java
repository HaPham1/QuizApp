package com.example.sit305quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usernameEditText;
    String name;

    public void jumpClick (View view)
    {
        if (usernameEditText.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, QuestionActivity1.class);
            intent.putExtra("name", usernameEditText.getText().toString());
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.editTextTextPersonName);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        usernameEditText.setText(name);
    }
}