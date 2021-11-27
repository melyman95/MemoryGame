package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EasyGame extends AppCompatActivity {

    private Button[][] gameButtons = new Button[3][3];

    private static int AMOUNT_OF_SQUARES = 9;
    private static int TIME_LIMIT = 180;
    private static long timeLeftInMilliseconds;
    private CountDownTimer gameTimer;
    private Button startTimerButton;
    private boolean isTimeLeft;

    // constructors
    public EasyGame() {

    }

    public EasyGame(int AMOUNT_OF_SQUARES, int TIME_LIMIT) {
        this.AMOUNT_OF_SQUARES = AMOUNT_OF_SQUARES;
        this.TIME_LIMIT = TIME_LIMIT;
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

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
    }

    public void startStop() {
        if (isTimeLeft) {
            stopTimer();
        }
        else{
            startTimer();
        }
    }

    public void startTimer() {

    }

    public void stopTimer() {

    }
}