/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametolo;

import gametolo.Tolo.TypeBet;
import java.util.ArrayList;

/**
 *
 * @author Shivam
 */
public class SuperBet extends Bet {

    int luckyNumber;

    public SuperBet(int luckyNumber, int betMoney) {
        super(betMoney);
        this.luckyNumber = luckyNumber;
    }

    @Override
    public int computeGain(Tolo t) {
        int gainAfterSuperBet = 0; //To change body of generated methods, choose Tools | Templates.

        if (this.luckyNumber == t.generateRandomWinningLuckyNumber()) {
            gainAfterSuperBet = t.getGain(TypeBet.BET) * 5;
        } else {
            gainAfterSuperBet = t.getGain(TypeBet.BET);
        }

        return gainAfterSuperBet;

    }
}
