package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EasyGame extends AppCompatActivity {

    private Button[][] gameButtons = new Button[3][3];
    private static int TIME_LIMIT = 1800;
    private CountDownTimer gameTimer;
    private final long timeLeft = TIME_LIMIT * 100;
    private Button startTimerButton;
    private TextView easyTimerText;

    // constructors
    public EasyGame() {

    }

    public EasyGame(int TIME_LIMIT) {
        EasyGame.TIME_LIMIT = TIME_LIMIT;
    }

    // getters and setters

    public static int getTIME_LIMIT() {
        return TIME_LIMIT;
    }

    public void setTIME_LIMIT(int TIME_LIMIT) {
        this.TIME_LIMIT = TIME_LIMIT;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView timerText = findViewById(R.id.timer);
        timerText.setText(String.valueOf(EasyGame.getTIME_LIMIT()));

        startTimerButton = findViewById(R.id.startTimerButton);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonId = "button" + i + j;
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                gameButtons[i][j] = findViewById(resId);
                gameButtons[i][j].setOnClickListener(v -> {

                });
            }
        }

        gameTimer = new CountDownTimer(timeLeft, 1000) {
            /**
             * Callback fired on regular interval.
             *
             * @param millisUntilFinished The amount of time until finished.
             */
            @Override
            public void onTick(long millisUntilFinished) {
                easyTimerText = findViewById(R.id.timer);
                easyTimerText.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            /**
             * Callback fired when the time is up.
             */
            @Override
            public void onFinish() {
                easyTimerText.setText("Time's up!");
            }
        };

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                gameTimer.start();
            }
        });
    }
}