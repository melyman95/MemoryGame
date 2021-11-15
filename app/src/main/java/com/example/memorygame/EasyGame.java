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

    public static int AMOUNT_OF_SQUARES = 0;
    public static int TIME_LIMIT = 0;

    Button[][] gameButtons = new Button[3][3];


    public EasyGame() {
        TIME_LIMIT = 200;
        AMOUNT_OF_SQUARES = 9;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Timer gameTimer = new Timer();
    }


}