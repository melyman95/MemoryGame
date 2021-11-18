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

    Button[][] gameButtons = new Button[3][3];

    private int AMOUNT_OF_SQUARES = 9;
    private int TIME_LIMIT = 180;
    private long timeLeftInMilliseconds;
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
    public Button[][] getGameButtons() {
        return gameButtons;
    }

    public void setGameButtons(Button[][] gameButtons) {
        this.gameButtons = gameButtons;
    }

    public int getAMOUNT_OF_SQUARES() {
        return AMOUNT_OF_SQUARES;
    }

    public void setAMOUNT_OF_SQUARES(int AMOUNT_OF_SQUARES) {
        this.AMOUNT_OF_SQUARES = AMOUNT_OF_SQUARES;
    }

    public int getTIME_LIMIT() {
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

        startTimerButton = findViewById(R.id.startTimerButton);

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