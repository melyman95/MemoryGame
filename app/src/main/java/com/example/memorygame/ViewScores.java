package com.example.memorygame;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.memorygame.databinding.ActivityViewScoresBinding;

import java.util.List;

public class ViewScores extends AppCompatActivity {

    private ActivityViewScoresBinding binding;
    ListView scoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scores);
        scoreList = findViewById(R.id.scoreListView);

        DbHelper dataBaseHelper = new DbHelper(ViewScores.this, "memGameDatabase", null, 1);
        List<Score> everyScore = dataBaseHelper.getAllScores();

        ArrayAdapter scoreAdapter = new ArrayAdapter<Score>(ViewScores.this, R.layout.support_simple_spinner_dropdown_item, everyScore);
        scoreList.setAdapter(scoreAdapter);
    }
}