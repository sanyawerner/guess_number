package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvinfo;
    EditText etinput;
    button bcontrol;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvinfo = (TextView)findViewById(R.id.textView2);
        etinput = (EditText)findViewById(R.id.edittext);
        bcontrol = (button)findViewById(R.id.button4);

        guess = (int)(Math.random()*100);
        gameFinished = false;

    }
    public void onClick(View v) {
        if (!gameFinished) {
            int inp = Integer.parseInt(etinput.getText().toString());
            if (inp > guess)
                tvinfo.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                tvinfo.setText("недолет!");
            if (inp == guess) {
                tvinfo.setText("в точку!");
                bcontrol.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        }
        else
        {
            guess = (int)Math.random()*100;
            bcontrol.setText("ввести значение");
            tvinfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished=false;
        }
    }
}