package com.example.memorygame;

public class Score {
    private int id;
    private String name;
    private int score;

    public Score (int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Score () {

    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " Name: " + getName() + " Score: " + getScore();
    }
}
