package com.sahaj.cleanstrike.service;

import static com.sahaj.cleanstrike.utils.Constants.*;

public class Winner {
    public int gameWinner(int[] score, int coin, int flag, int redCoin) {
        if(score[0] >=5 && (score[0]-score[1]) >= 3) {
            System.out.println(PLAYER_1_WINS);
            System.out.println(PLAYER_1_SCORES + score[0]);
            System.out.println(PLAYER_2_SCORES + score[1]);
            flag = 1;
        } else if(score[1] >= 5 && (score[1] - score[0]) >= 3) {
            System.out.println(PLAYER_2_WINS);
            System.out.println(PLAYER_1_SCORES + score[0]);
            System.out.println(PLAYER_2_SCORES + score[1]);
            flag = 1;
        } else if(coin == 0 && redCoin==0) {
            if(((score[0] < 5 && score[1] < 5) && score[0]-score[1] < 3) || (score[0]==score[1])) {
                System.out.println(MATCH_DRAW);
                System.out.println(PLAYER_1_SCORES + score[0]);
                System.out.println(PLAYER_2_SCORES + score[1]);
            } else if(score[0] > score[1]) {
                System.out.println(PLAYER_1_WINS_AT_LAST);
                System.out.println(PLAYER_1_SCORES + score[0]);
                System.out.println(PLAYER_2_SCORES + score[1]);
            } else {
                System.out.println(PLAYER_2_WINS_AT_LAST);
                System.out.println(PLAYER_1_SCORES + score[0]);
                System.out.println(PLAYER_2_SCORES + score[1]);
            }
            flag = 1;
        }
        return flag;
    }
}
