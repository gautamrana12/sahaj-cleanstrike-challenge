package com.sahaj.cleanstrike.model;

public class CarromBoard {
    int[] score;
    int strike;

    public CarromBoard() {}

    public CarromBoard(int[] score, int strike) {
        this.score = score;
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public int[] getScore() {
        return score;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setScoreUp(int playerToss, int value) {
        this.score[playerToss] += value;
    }

    public void setScoreDown(int playerToss, int value) {
        this.score[playerToss] -= value;
    }
}
