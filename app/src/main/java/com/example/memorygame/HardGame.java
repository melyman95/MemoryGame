package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class HardGame extends AppCompatActivity {

    Button[][] gameButtons = new Button[3][6];
    private static int TIME_LIMIT = 300;
    private CountDownTimer gameTimer;
    private final long timeLeft = TIME_LIMIT * 100;
    private Button startTimerButton;
    private TextView hardTimerText;

    public HardGame() {

    }

    public HardGame(int TIME_LIMIT) {
        HardGame.TIME_LIMIT = TIME_LIMIT;
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
        setContentView(R.layout.activity_hard_game);

        TextView timerText = findViewById(R.id.hardTimerText);
        timerText.setText(String.valueOf(HardGame.getTIME_LIMIT()));

        startTimerButton = findViewById(R.id.buttonHardStart);

        gameButtons[0][0] = findViewById(R.id.buttonHard1);
        gameButtons[0][1] = findViewById(R.id.buttonHard2);
        gameButtons[0][2] = findViewById(R.id.buttonHard3);
        gameButtons[0][3] = findViewById(R.id.buttonHard4);
        gameButtons[0][4] = findViewById(R.id.buttonHard5);
        gameButtons[0][5] = findViewById(R.id.buttonHard6);
        gameButtons[1][0] = findViewById(R.id.buttonHard7);
        gameButtons[1][1] = findViewById(R.id.buttonHard8);
        gameButtons[1][2] = findViewById(R.id.buttonHard9);
        gameButtons[1][3] = findViewById(R.id.buttonHard10);
        gameButtons[1][4] = findViewById(R.id.buttonHard11);
        gameButtons[1][5] = findViewById(R.id.buttonHard12);
        gameButtons[2][0] = findViewById(R.id.buttonHard13);
        gameButtons[2][1] = findViewById(R.id.buttonHard14);
        gameButtons[2][2] = findViewById(R.id.buttonHard15);
        gameButtons[2][3] = findViewById(R.id.buttonHard16);
        gameButtons[2][4] = findViewById(R.id.buttonHard17);
        gameButtons[2][5] = findViewById(R.id.buttonHard18);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                gameButtons[i][j].setOnClickListener(v -> {

                });
            }
        }

        gameTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                hardTimerText = findViewById(R.id.hardTimerText);
                hardTimerText.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                hardTimerText.setText("Time's up!");
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