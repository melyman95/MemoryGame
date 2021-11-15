package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class EasyGame extends AppCompatActivity {

    Button[][] gameButtons = new Button[3][3];

    private int AMOUNT_OF_SQUARES = 9;
    private int TIME_LIMIT = 180;

    public EasyGame() {

    }

    public EasyGame(int AMOUNT_OF_SQUARES, int TIME_LIMIT) {
        this.AMOUNT_OF_SQUARES = AMOUNT_OF_SQUARES;
        this.TIME_LIMIT = TIME_LIMIT;
    }

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

        Timer gameTimer = new Timer();
    }


}