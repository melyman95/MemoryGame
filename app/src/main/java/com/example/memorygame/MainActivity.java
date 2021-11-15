package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView brain = findViewById(R.id.brain);
        int imageResource = getResources().getIdentifier("@drawable/brain",
                null, this.getPackageName());
        brain.setImageResource(imageResource);
    }
}