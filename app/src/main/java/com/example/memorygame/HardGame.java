package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class HardGame extends AppCompatActivity {

    Button[][] gameButtons = new Button[3][6];

    public HardGame() {
        final int TIME_LIMIT = 30;
        final int AMOUNT_OF_SQUARES = 18;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_game);
    }
}