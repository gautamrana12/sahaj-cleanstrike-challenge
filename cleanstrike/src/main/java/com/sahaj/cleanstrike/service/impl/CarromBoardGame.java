package com.sahaj.cleanstrike.service.impl;

import com.sahaj.cleanstrike.model.CarromBoard;
import com.sahaj.cleanstrike.model.Coins;
import com.sahaj.cleanstrike.model.Player;
import com.sahaj.cleanstrike.service.ICarromBoardGame;
import com.sahaj.cleanstrike.service.Winner;

import static com.sahaj.cleanstrike.utils.Action.*;
import static com.sahaj.cleanstrike.utils.Constants.*;

public class CarromBoardGame implements ICarromBoardGame {

    private static int FLAG = 0;

    @Override
    public void playCarrom() {
        CarromBoard carromBoard = new CarromBoard(new int[2], 0);
        Coins coins = new Coins(TOTAL_COINS,RED_COIN);
        Player player = new Player(new int[2], new int[2], (int)(Math.random()*2));
        Winner winner = new Winner();
        while(true){
            carromBoard.setStrike((int)(Math.random()*TOTAL_ACTIONS));
            if((carromBoard.getStrike() >=0 && carromBoard.getStrike() <=8) && coins.getCoins()!=0) {
                carromBoard.setScoreUp(player.getPlayerToss(), COIN_STRIKE);    // Coins
                coins.setCoins(1);
                player.setPlayerStats(player.getPlayerToss(),0);
            } else if(carromBoard.getStrike()==RED_POCKETED && coins.getRedCoin()!=0) {
                carromBoard.setScoreUp(player.getPlayerToss(), RED_STRIKE);    //Red Strike
                player.setPlayerStats(player.getPlayerToss(),0);
                coins.setRedCoin(0);
            } else if(carromBoard.getStrike()==STRIKER_POCKETED) {
                carromBoard.setScoreDown(player.getPlayerToss(), STRIKER_STRIKE);    //Striker Strike
                player.setPlayerFoul(player.getPlayerToss(), 1);
            } else if(carromBoard.getStrike()==BAD_SHOT) {
                carromBoard.setScoreDown(player.getPlayerToss(), DEFUNCT_COINS);    // Defunct Coins
                coins.setCoins(1);
                player.setPlayerFoul(player.getPlayerToss(), 1);
            } else if(carromBoard.getStrike()==BRAVO) {
                int coinPocketed = (int)(Math.random()*coins.getCoins());
                coins.setCoins(coins.getCoins()-coinPocketed);
                carromBoard.setScoreUp(player.getPlayerToss(), MULTI_STRIKE);      //Multi Strike
                coins.setCoins(2);
                player.setPlayerStats(player.getPlayerToss(), 0);
            } else if(carromBoard.getStrike()==OOPS_YOU_LOST_A_POINT) {                 //Successive 3 turns no coin Pocketed
                if(player.getPlayerToss()==0) {
                    player.setPlayerStats(player.getPlayerToss(), 1);
                    if(player.getPlayerStats()==THREE_TIMES_HARD_LUCK) {
                        carromBoard.setScoreDown(player.getPlayerToss(), 1);
                        player.setPlayerFoul(player.getPlayerToss(),1);
                    }
                } else {
                    player.setPlayerStats(player.getPlayerToss(), 1);
                    if(player.getPlayerStats()==THREE_TIMES_HARD_LUCK) {
                        carromBoard.setScoreDown(player.getPlayerToss(), 1);
                        player.setPlayerFoul(player.getPlayerToss(),1);
                    }
                }
            }
            if(player.getPlayerFoul()==PLAYER_FOUL_LIMIT) {
                carromBoard.setScoreDown(player.getPlayerToss(), 1);
            }
            CarromBoardGame.FLAG = winner.gameWinner(carromBoard.getScore(), coins.getCoins(), CarromBoardGame.FLAG, coins.getRedCoin());
            if(CarromBoardGame.FLAG==1)
                break;
            player.setPlayerToss(1 - player.getPlayerToss());
        }
    }
}
