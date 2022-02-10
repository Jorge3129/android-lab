package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ageEditText;
    private EditText nameEditText;
    private TextView feedbackTitle;
    private TextView feedbackValue;
    public static final String EXTRA_MESSAGE1 = "extra.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "extra.MESSAGE2";
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageEditText = findViewById(R.id.ageInput);
        nameEditText = findViewById(R.id.nameInput);
        feedbackTitle = findViewById(R.id.feedback_title);
        feedbackValue = findViewById(R.id.feedback_value);
    }

    public void newActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        String age = ageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1, age);

        String name = nameEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE2, name);

        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                feedbackValue.setText(reply);
            }
        }
    }
}