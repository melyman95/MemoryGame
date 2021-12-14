package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class HardGame extends AppCompatActivity {

    private final ImageButton[] gameButtons = new ImageButton[20];
    private static int SQUARES_AMOUNT = 20;
    private static int TIME_LIMIT = 300;
    private CountDownTimer gameTimer;
    private final long timeLeft = TIME_LIMIT * 100;
    private Button startTimerButton;
    private TextView hardTimerText;

    public HardGame() {

    }

    public HardGame(int TIME_LIMIT, int squares) {
        HardGame.SQUARES_AMOUNT = squares;
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

        ArrayList<Integer> imageArray = new ArrayList<>();
        imageArray.add(R.drawable.apple);
        imageArray.add(R.drawable.apple);
        imageArray.add(R.drawable.crab);
        imageArray.add(R.drawable.crab);
        imageArray.add(R.drawable.pikachu);
        imageArray.add(R.drawable.pikachu);
        imageArray.add(R.drawable.donut);
        imageArray.add(R.drawable.donut);
        imageArray.add(R.drawable.watermelon);
        imageArray.add(R.drawable.watermelon);
        imageArray.add(R.drawable.beachball);
        imageArray.add(R.drawable.beachball);
        imageArray.add(R.drawable.pizzaglasses);
        imageArray.add(R.drawable.pizzaglasses);
        imageArray.add(R.drawable.potatohead);
        imageArray.add(R.drawable.potatohead);
        imageArray.add(R.drawable.sodacan);
        imageArray.add(R.drawable.sodacan);
        imageArray.add(R.drawable.sun);
        imageArray.add(R.drawable.sun);

        Collections.shuffle(imageArray);

        TextView timerText = findViewById(R.id.hardTimerText);
        timerText.setText(String.valueOf(HardGame.getTIME_LIMIT()));

        startTimerButton = findViewById(R.id.buttonHardStart);

        gameButtons[0] = findViewById(R.id.imageButtonHard1);
        gameButtons[1] = findViewById(R.id.imageButtonHard2);
        gameButtons[2] = findViewById(R.id.imageButtonHard3);
        gameButtons[3] = findViewById(R.id.imageButtonHard4);
        gameButtons[4] = findViewById(R.id.imageButtonHard5);
        gameButtons[5] = findViewById(R.id.imageButtonHard6);
        gameButtons[6] = findViewById(R.id.imageButtonHard7);
        gameButtons[7] = findViewById(R.id.imageButtonHard8);
        gameButtons[8] = findViewById(R.id.imageButtonHard9);
        gameButtons[9] = findViewById(R.id.imageButtonHard10);
        gameButtons[10] = findViewById(R.id.imageButtonHard11);
        gameButtons[11] = findViewById(R.id.imageButtonHard12);
        gameButtons[12] = findViewById(R.id.imageButtonHard13);
        gameButtons[13] = findViewById(R.id.imageButtonHard14);
        gameButtons[14] = findViewById(R.id.imageButtonHard15);
        gameButtons[15] = findViewById(R.id.imageButtonHard16);
        gameButtons[16] = findViewById(R.id.imageButtonHard17);
        gameButtons[17] = findViewById(R.id.imageButtonHard18);
        gameButtons[18] = findViewById(R.id.imageButtonHard19);
        gameButtons[19] = findViewById(R.id.imageButtonHard20);

        disableInput();

        for (int i = 0; i < SQUARES_AMOUNT; i++) {
            int finalI = i;
            gameButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (gameButtons[finalI].getBackground() != null) {
                        gameButtons[finalI].setImageResource(imageArray.get(finalI));
                    }
                }
            });
        }

        gameTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                hardTimerText = findViewById(R.id.hardTimerText);
                hardTimerText.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                disableInput();
                hardTimerText.setText("Time's up!");
            }
        };

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset();
                enableInput();
                gameTimer.start();
            }
        });
    }

    public void disableInput() {
        for (int i = 0; i < SQUARES_AMOUNT; i++) {
            gameButtons[i].setEnabled(false);
        }
    }

    public void enableInput() {
        for (int i = 0; i < SQUARES_AMOUNT; i++) {
            gameButtons[i].setEnabled(true);
        }
    }

    public void Reset() {
        for (int i = 0; i < SQUARES_AMOUNT; i++) {
            gameButtons[i].setImageResource(R.drawable.cardback);
        }
    }
}