package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView brain = findViewById(R.id.brain);
        int imageResource = getResources().getIdentifier("@drawable/brain",
                null, this.getPackageName());
        brain.setImageResource(imageResource);

        Button newGameButton = findViewById(R.id.newGameButton);
        Button highScoresButton = findViewById(R.id.highScoresButton);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivityEasy.class);
        startActivity(intent);
    }
}