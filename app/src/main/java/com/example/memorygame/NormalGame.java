package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NormalGame extends AppCompatActivity {

    private static Button[][] gameButtons = new Button[3][4];

    private static int AMOUNT_OF_SQUARES = 12;
    private static int TIME_LIMIT = 120;

    public NormalGame() {

    }

    public NormalGame(int AMOUNT_OF_SQUARES, int TIME_LIMIT) {
        this.AMOUNT_OF_SQUARES = AMOUNT_OF_SQUARES;
        this.TIME_LIMIT = TIME_LIMIT;
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
    }
}