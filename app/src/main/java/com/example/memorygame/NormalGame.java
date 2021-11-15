package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class NormalGame extends AppCompatActivity {

    Button[][] gameButtons = new Button[3][4];

    public NormalGame() {
        final int TIME_LIMIT = 100;
        final int AMOUNT_OF_SQUARES = 12;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game);
    }
}