package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

public class NormalGame extends AppCompatActivity {

    private static Button[][] gameButtons = new Button[3][4];
    private static int TIME_LIMIT = 1200;
    private CountDownTimer gameTimer;
    private final long timeLeft = TIME_LIMIT * 100;
    private Button startTimerButton;
    private TextView normalTimerText;

    public NormalGame() {

    }

    public NormalGame(int TIME_LIMIT) {
        NormalGame.TIME_LIMIT = TIME_LIMIT;
    }

    public static int getTIME_LIMIT() {
        return TIME_LIMIT;
    }

    public void setTIME_LIMIT(int TIME_LIMIT) {
        this.TIME_LIMIT = TIME_LIMIT;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game);

        TextView timerText = findViewById(R.id.normalTimerText);
        timerText.setText(String.valueOf(NormalGame.getTIME_LIMIT()));

        startTimerButton = findViewById(R.id.buttonStartNormal);
        normalTimerText = findViewById(R.id.normalTimerText);

        gameButtons[0][0] = findViewById(R.id.buttonNormal1);
        gameButtons[0][1] = findViewById(R.id.buttonNormal2);
        gameButtons[0][2] = findViewById(R.id.buttonNormal3);
        gameButtons[0][3] = findViewById(R.id.buttonNormal4);
        gameButtons[1][0] = findViewById(R.id.buttonNormal5);
        gameButtons[1][1] = findViewById(R.id.buttonNormal6);
        gameButtons[1][2] = findViewById(R.id.buttonNormal7);
        gameButtons[1][3] = findViewById(R.id.buttonNormal8);
        gameButtons[2][0] = findViewById(R.id.buttonNormal9);
        gameButtons[2][1] = findViewById(R.id.buttonNormal10);
        gameButtons[2][2] = findViewById(R.id.buttonNormal11);
        gameButtons[2][3] = findViewById(R.id.buttonNormal12);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                gameButtons[i][j].setOnClickListener(v -> {

                });
            }
        }

        gameTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                normalTimerText = findViewById(R.id.normalTimerText);
                normalTimerText.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                normalTimerText.setText("Time's up!");
            }
        };

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameTimer.start();
            }
        });
    }
}