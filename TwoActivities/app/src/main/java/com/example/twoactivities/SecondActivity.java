package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView messageTextView;
    public static String EXTRA_MESSAGE="myKey";
    private EditText msgEditText;
    private static String Clicker = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        messageTextView=findViewById(R.id.text_Message);
        Intent myIntent = getIntent();
        String message = myIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        messageTextView.setText(message);
        msgEditText = findViewById(R.id.reply_text);
    }
    public void launchMainActivity(View view){
        Intent intent = new Intent(this,MainActivity.class);
        Log.d(Clicker,"Reply sent");
        String message = msgEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}