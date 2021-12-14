package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Console;
import java.util.List;

public class GameHomeScreen extends AppCompatActivity {

    public static boolean EASY = false;
    public static boolean NORMAL = false;
    public static boolean HARD = false;

    SQLiteDatabase memGameDatabase;
    String queryString;

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

        RadioButton easyButton = findViewById(R.id.easy);
        RadioButton normalButton = findViewById(R.id.normal);

        RadioGroup difficultyButtons = new RadioGroup(getApplicationContext());

        easyButton.setChecked(true);

        highScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = viewHighScores();
                startActivity(intent);
            }
        });
    }

    public void startGame(View view) {

        Intent intent = new Intent();

        setEASY(findViewById(R.id.easy));
        setNORMAL(findViewById(R.id.normal));

        if (EASY == true) {
            intent = EasyGame();
        }
        if (NORMAL == true) {
            intent = NormalGame();
        }
        if (HARD == true) {
            intent = HardGame();
        }

        startActivity(intent);
    }

    public Intent EasyGame() {
        Intent intent = new Intent(this, EasyGame.class);

        return intent;
    }

    public Intent NormalGame() {
        Intent intent = new Intent(this, NormalGame.class);

        return intent;
    }

    public Intent HardGame() {
        Intent intent = new Intent(this, HardGame.class);

        return intent;
    }

    public void setEASY(RadioButton button) {
        if (button.isChecked()) {
            EASY = true;
        }
        else {
            EASY = false;
        }
    }

    public void setNORMAL(RadioButton button) {
        if (button.isChecked()) {
            NORMAL = true;
        }
        else {
            NORMAL = false;
        }
    }

    public void setHARD (RadioButton button) {
        if (button.isChecked()) {
            HARD = true;
        }
        else {
            HARD = false;
        }
    }

    public Intent viewHighScores() {
        Intent intent = new Intent(this, ViewScores.class);
        return intent;
    }
}