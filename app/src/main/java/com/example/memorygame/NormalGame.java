package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.*;

public class NormalGame extends AppCompatActivity {

    private static int SQUARES_AMOUNT = 15;
    private static ImageButton[] gameButtons = new ImageButton[15];
    private static int TIME_LIMIT = 1200;
    private CountDownTimer gameTimer;
    private final long timeLeft = TIME_LIMIT * 100;
    private Button startTimerButton;
    private TextView normalTimerText;

    public NormalGame() {

    }

    public NormalGame(int TIME_LIMIT, int squares) {
        NormalGame.TIME_LIMIT = TIME_LIMIT;
        NormalGame.SQUARES_AMOUNT = squares;
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
        imageArray.add(R.drawable.watermelon);

        Collections.shuffle(imageArray);

        TextView timerText = findViewById(R.id.normalTimerText);
        timerText.setText(String.valueOf(NormalGame.getTIME_LIMIT()));

        startTimerButton = findViewById(R.id.buttonStartNormal);
        normalTimerText = findViewById(R.id.normalTimerText);

        gameButtons[0] = findViewById(R.id.imageButtonNormal1);
        gameButtons[1] = findViewById(R.id.imageButtonNormal2);
        gameButtons[2] = findViewById(R.id.imageButtonNormal3);
        gameButtons[3] = findViewById(R.id.imageButtonNormal4);
        gameButtons[4] = findViewById(R.id.imageButtonNormal5);
        gameButtons[5] = findViewById(R.id.imageButtonNormal6);
        gameButtons[6] = findViewById(R.id.imageButtonNormal7);
        gameButtons[7] = findViewById(R.id.imageButtonNormal8);
        gameButtons[8] = findViewById(R.id.imageButtonNormal9);
        gameButtons[9] = findViewById(R.id.imageButtonNormal10);
        gameButtons[10] = findViewById(R.id.imageButtonNormal11);
        gameButtons[11] = findViewById(R.id.imageButtonNormal12);
        gameButtons[12] = findViewById(R.id.imageButtonNormal13);
        gameButtons[13] = findViewById(R.id.imageButtonNormal14);
        gameButtons[14] = findViewById(R.id.imageButtonNormal15);

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

        disableInput();

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
}