package com.example.memorygame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterNameFragment extends Fragment {
    private static EditText editText;
    private static Button okButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_enter_name, container, false);

        editText = v.findViewById(R.id.enterNameField);
        okButton = v.findViewById(R.id.confirmNameButton);

        editText.setText("Your Name Here");

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Score score;
                    if (GameHomeScreen.EASY == true) {
                        score = new Score(1, EnterNameFragment.getPlayerName(), EasyGame.getPlayerScore());
                        DbHelper helper = new DbHelper(getContext(), "HIGH_SCORES", null, 1);
                        helper.addScore(score);
                        Toast.makeText(getContext(), score.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if (GameHomeScreen.NORMAL == true) {
                        score = new Score(1, EnterNameFragment.getPlayerName(), NormalGame.getPlayerScore());
                        DbHelper helper = new DbHelper(getContext(), "HIGH_SCORES", null, 1);
                        helper.addScore(score);
                        Toast.makeText(getContext(), score.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(getContext(), "Error creating score.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    public static String getPlayerName() {
        return editText.getText().toString();
    }
}