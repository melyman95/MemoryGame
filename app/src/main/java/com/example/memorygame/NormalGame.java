package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

public class NormalGame extends AppCompatActivity {

    private static final ImageView[] gameButtons = new ImageView[20];
    private static int playerScore = 100;
    private static int TIME_LIMIT = 1200;
    private CountDownTimer gameTimer;
    private final long timeLeft = TIME_LIMIT * 100;
    private Button startTimerButton;
    private Button enterNameButton;
    private TextView normalTimerText;
    private static int SQUARES_AMOUNT = 20;
    public static int clicked;
    public static int lastClicked;

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

        enterNameButton = findViewById(R.id.enterNameButtonNormal);

        Integer[] playingCards = {R.drawable.apple, R.drawable.sodacan, R.drawable.watermelon,
                R.drawable.pikachu, R.drawable.water, R.drawable.donut, R.drawable.apple, R.drawable.sodacan, R.drawable.watermelon,
                R.drawable.pikachu, R.drawable.water, R.drawable.donut, R.drawable.pizzaglasses,
        R.drawable.pizzaglasses, R.drawable.plankton, R.drawable.plankton, R.drawable.pumpkin,
        R.drawable.pumpkin, R.drawable.flower, R.drawable.flower};

        Collections.shuffle(Arrays.asList(playingCards));

        TextView timerText = findViewById(R.id.normalTimerText);
        timerText.setText("");
        TextView scoreText = findViewById(R.id.playerScoreNormal);
        scoreText.setText(String.valueOf(playerScore));

        Button startTimerButton = findViewById(R.id.buttonStartNormal);

        gameButtons[0] = findViewById(R.id.imageViewNormal);
        gameButtons[1] = findViewById(R.id.imageViewNormal2);
        gameButtons[2] = findViewById(R.id.imageViewNormal3);
        gameButtons[3] = findViewById(R.id.imageViewNormal4);
        gameButtons[4] = findViewById(R.id.imageViewNormal5);
        gameButtons[5] = findViewById(R.id.imageViewNormal6);
        gameButtons[6] = findViewById(R.id.imageViewNormal7);
        gameButtons[7] = findViewById(R.id.imageViewNormal8);
        gameButtons[8] = findViewById(R.id.imageViewNormal9);
        gameButtons[9] = findViewById(R.id.imageViewNormal10);
        gameButtons[10] = findViewById(R.id.imageViewNormal11);
        gameButtons[11] = findViewById(R.id.imageViewNormal12);
        gameButtons[12] = findViewById(R.id.imageViewNormal13);
        gameButtons[13] = findViewById(R.id.imageViewNormal14);
        gameButtons[14] = findViewById(R.id.imageViewNormal15);
        gameButtons[15] = findViewById(R.id.imageViewNormal16);
        gameButtons[16] = findViewById(R.id.imageViewNormal17);
        gameButtons[17] = findViewById(R.id.imageViewNormal18);
        gameButtons[18] = findViewById(R.id.imageViewNormal19);
        gameButtons[19] = findViewById(R.id.imageViewNormal20);


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

        disableInput();

        gameTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                normalTimerText = findViewById(R.id.normalTimerText);
                normalTimerText.setText("seconds remaining: " + millisUntilFinished / 1000);
                if (playerScore > 0) {
                    playerScore -= 1;
                }
                else if (playerScore <= 0) {
                    playerScore += 0;
                }
                scoreText.setText(String.valueOf(getPlayerScore()));

                if (gameEnd()) {
                    if (gameTimer != null) {
                        gameTimer.cancel();
                        gameTimer = null;
                        enterNameButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void onFinish() {
                disableInput();
                normalTimerText.setText("Time's up!");
                enterNameButton.setEnabled(true);
            }
        };

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableInput();
                scoreText.setText(String.valueOf(100));
                Reset();
                enableInput();
                gameTimer.cancel();
                gameTimer.start();
            }
        });
        disableInput();
        enterNameButton.setEnabled(false);
        scoreText.setText(String.valueOf(100));
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

    public void enterName(View view) {
        Fragment frag = new EnterNameFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.action_bar_container, frag);
        transaction.addToBackStack(null);
        transaction.commit();
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

    public static int getPlayerScore() {
        return playerScore;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        playerScore = 100;
        gameTimer.cancel();
    }
}