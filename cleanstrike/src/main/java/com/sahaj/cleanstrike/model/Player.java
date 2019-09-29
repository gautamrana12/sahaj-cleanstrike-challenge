package com.sahaj.cleanstrike.model;

public class Player {

    int [] playerStats;
    int []playerFoul;
    int playerToss;

    public Player() {
    }

    public Player(int[] playerStats, int[] playerFoul, int playerToss) {
        this.playerStats = playerStats;
        this.playerFoul = playerFoul;
        this.playerToss = playerToss;
    }

    public int getPlayerStats() {
        return playerStats[playerToss];
    }

    public void setPlayerStats(int playerToss, int value) {
        this.playerStats[playerToss] = value;
    }

    public int getPlayerFoul() {
        return playerFoul[playerToss];
    }

    public void setPlayerFoul(int playerToss, int value) {
//        this.playerFoul = playerFoul;
        this.playerFoul[playerToss] += value;
    }

    public int getPlayerToss() {
        return playerToss;
    }

    public void setPlayerToss(int playerToss) {
        this.playerToss = playerToss;
    }
}
