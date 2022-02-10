package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView ageTextView;
    private TextView nameTextView;
    private EditText feedbackEditText;
    public static final String EXTRA_REPLY = "extra.REPLY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        ageTextView = findViewById(R.id.ageValue);
        nameTextView = findViewById(R.id.nameValue);
        feedbackEditText = findViewById(R.id.feedback);

        Intent intent = getIntent();

        String age = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        ageTextView.setText(age);

        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        nameTextView.setText(name);
    }

    public void returnToMain(View view){
        String feedback = feedbackEditText.getText().toString();

        Intent feedbackIntent = new Intent();
        feedbackIntent.putExtra(EXTRA_REPLY, feedback);
        setResult(RESULT_OK, feedbackIntent);
        finish();
    }
}
