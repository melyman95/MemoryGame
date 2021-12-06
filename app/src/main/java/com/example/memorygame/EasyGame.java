package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.*;

public class EasyGame extends AppCompatActivity {

    private final ImageButton[] gameButtons = new ImageButton[9];
    private static int TIME_LIMIT = 1800;
    private CountDownTimer gameTimer;
    private final long timeLeft = TIME_LIMIT * 100L;
    private TextView easyTimerText;
    public static int SQUARES_AMOUNT = 9;

    // constructors
    public EasyGame() {

    }

    public EasyGame(int TIME_LIMIT, int SQUARES_AMOUNT) {
        EasyGame.SQUARES_AMOUNT = SQUARES_AMOUNT;
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

        ArrayList<Integer> imageArray = new ArrayList<>();
        imageArray.add(R.drawable.apple);
        imageArray.add(R.drawable.apple);
        imageArray.add(R.drawable.beachball);
        imageArray.add(R.drawable.beachball);
        imageArray.add(R.drawable.donut);
        imageArray.add(R.drawable.donut);
        imageArray.add(R.drawable.pikachu);
        imageArray.add(R.drawable.pikachu);
        imageArray.add(R.drawable.pizzaglasses);

        Collections.shuffle(imageArray);

        TextView timerText = findViewById(R.id.timer);
        timerText.setText(String.valueOf(EasyGame.getTIME_LIMIT()));

        Button startTimerButton = findViewById(R.id.startTimerButton);

        gameButtons[0] = findViewById(R.id.imageButtonEasy1);
        gameButtons[1] = findViewById(R.id.imageButtonEasy2);
        gameButtons[2] = findViewById(R.id.imageButtonEasy3);
        gameButtons[3] = findViewById(R.id.imageButtonEasy4);
        gameButtons[4] = findViewById(R.id.imageButtonEasy5);
        gameButtons[5] = findViewById(R.id.imageButtonEasy6);
        gameButtons[6] = findViewById(R.id.imageButtonEasy7);
        gameButtons[7] = findViewById(R.id.imageButtonEasy8);
        gameButtons[8] = findViewById(R.id.imageButtonEasy9);

        for (int i = 0; i < SQUARES_AMOUNT; i++) {
            int finalI = i;
            int finalI1 = i;
            gameButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (gameButtons[finalI1].getBackground() != null) {
                        gameButtons[finalI].setImageResource(imageArray.get(finalI));
                    }
                }
            });
        }

        disableInput();

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

    public static Integer getRandomImage(ArrayList<Integer> images) {
        int index = (int)(Math.random() * images.size());
        return images.get(index);
    }
}