package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.memorygame.R.drawable.*;

import java.lang.reflect.Array;
import java.util.*;

public class EasyGame extends AppCompatActivity {

    private static final ImageView[] gameButtons = new ImageView[12];
    private Button enterNameButton;
    private static int TIME_LIMIT = 1800;
    private CountDownTimer gameTimer;
    private final long timeLeft = TIME_LIMIT * 100L;
    private TextView easyTimerText;
    private static int SQUARES_AMOUNT = gameButtons.length;
    public static int clicked = 0;
    public static int lastClicked = -1;
    private static int playerScore = 100;
    private boolean turnOver;

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
        setContentView(R.layout.activity_easy_game);

        enterNameButton = findViewById(R.id.enterNameButton);
        //enterNameButton.setEnabled(false);

        Integer[] playingCards = {R.drawable.apple, R.drawable.sodacan, R.drawable.watermelon,
        R.drawable.pikachu, R.drawable.water, R.drawable.donut, R.drawable.apple, R.drawable.sodacan, R.drawable.watermelon,
                R.drawable.pikachu, R.drawable.water, R.drawable.donut};

        Drawable cardBack = getDrawable(R.drawable.cardback);

        gameButtons[0] = findViewById(R.id.imageView);
        gameButtons[1] = findViewById(R.id.imageView2);
        gameButtons[2] = findViewById(R.id.imageView3);
        gameButtons[3] = findViewById(R.id.imageView4);
        gameButtons[4] = findViewById(R.id.imageView5);
        gameButtons[5] = findViewById(R.id.imageView6);
        gameButtons[6] = findViewById(R.id.imageView7);
        gameButtons[7] = findViewById(R.id.imageView8);
        gameButtons[8] = findViewById(R.id.imageView9);
        gameButtons[9] = findViewById(R.id.imageView10);
        gameButtons[10] = findViewById(R.id.imageView11);
        gameButtons[11] = findViewById(R.id.imageView12);

        Collections.shuffle(Arrays.asList(playingCards));

        TextView timerText = findViewById(R.id.easyTimer);
        timerText.setText(String.valueOf(EasyGame.getTIME_LIMIT()));
        TextView scoreText = findViewById(R.id.playerScore);
        scoreText.setText(String.valueOf(playerScore));

        Button startTimerButton = findViewById(R.id.startTimerButton);

        for (int i = 0; i < SQUARES_AMOUNT; i++) {
            gameButtons[i].setTag(R.drawable.cardback);
            int finalI = i;
            gameButtons[i].setImageResource(R.drawable.cardback);
            gameButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((Integer)gameButtons[finalI].getTag() == R.drawable.cardback && clicked < 2) {
                        gameButtons[finalI].setImageResource(playingCards[finalI]);
                        gameButtons[finalI].setTag(playingCards[finalI]);
                        if (clicked == 0) {
                            lastClicked = finalI;
                        }
                        clicked++;
                    } else if ((Integer)gameButtons[finalI].getTag() != R.drawable.cardback) {
                        gameButtons[finalI].setImageResource(R.drawable.cardback);
                        gameButtons[finalI].setTag(R.drawable.cardback);
                        clicked--;
                    }
                    if (clicked == 2) {
                        if (gameButtons[finalI].getTag() == gameButtons[lastClicked].getTag()) {
                            gameButtons[finalI].setEnabled(false);
                            gameButtons[lastClicked].setEnabled(false);
                            clicked = 0;
                        }
                    }
                }
            });
        }

        gameTimer = new CountDownTimer(timeLeft, 1000) {
            /**
             * Callback fired on regular interval.
             *
             * @param millisUntilFinished The amount of time until finished.
             */
            @Override
            public void onTick(long millisUntilFinished) {
                easyTimerText = findViewById(R.id.easyTimer);
                easyTimerText.setText("seconds remaining: " + millisUntilFinished / 1000);
                playerScore -= 1;
                scoreText.setText(String.valueOf(getPlayerScore()));

                if (gameEnd()) {
                    if (gameTimer != null) {
                        gameTimer.cancel();
                        gameTimer = null;
                    }
                }
            }

            /**
             * Callback fired when the time is up.
             */
            @Override
            public void onFinish() {
                disableInput();
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
            gameButtons[i].setBackgroundResource(R.drawable.cardback);
        }
    }

    public void enterName(View view) {
        Fragment frag = new EnterNameFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.action_bar_container, frag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static int getPlayerScore() {
        return playerScore;
    }

    public boolean gameEnd() {
        int count = 0;
        for (int i = 0; i < SQUARES_AMOUNT; i++) {
            if ((Integer)gameButtons[i].getTag() != R.drawable.cardback) {
                count++;
            }
        }
        return count == SQUARES_AMOUNT;
    }
}