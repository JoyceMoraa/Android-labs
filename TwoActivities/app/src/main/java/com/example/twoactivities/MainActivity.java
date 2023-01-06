
package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE="myKey";
    private TextView msgTextView;
    private static String clicker = MainActivity.class.getSimpleName();
    //declaration
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTextView = findViewById(R.id.reply_container);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SecondActivity.EXTRA_MESSAGE);
        msgTextView.setText(message);
        //initialization
        messageEditText=findViewById(R.id.editTextTextMultiLine);
    }

    public void launchSecondActivity(View view) {
        Intent myIntent = new Intent(this,SecondActivity.class);
        Log.d(clicker,"Button Clicked");
        String message = messageEditText.getText().toString();
        myIntent.putExtra(EXTRA_MESSAGE,message);
        startActivity(myIntent);
    }
}
