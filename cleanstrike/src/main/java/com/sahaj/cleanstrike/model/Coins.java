package com.sahaj.cleanstrike.model;

public class Coins {

    private int coins;
    private int redCoin;

    public Coins() {}

    public Coins(int coins, int redCoin) {
        this.coins = coins;
        this.redCoin = redCoin;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coin) {
        if(coin==2) {
            this.coins += coin;
        } else {
            this.coins -= coin;
        }
    }

    public int getRedCoin() {
        return redCoin;
    }

    public void setRedCoin(int redCoin) {
        this.redCoin = redCoin;
    }
}
