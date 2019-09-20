/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametolo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Shivam
 */

public class Tolo {

    private ArrayList<Integer> drawNumbers;
    Bet bet;
    SuperBet sb;
    int winningLuckyNumber;

    public static enum TypeBet {
        BET,
        SUPERBET;
    }

    public Tolo() {
        this.drawNumbers = new ArrayList<Integer>();
        adddrawNumbers();
    }

    public void adddrawNumbers() {
        int i = 1;
        while (i <= 20) {
            this.drawNumbers.add(i);
            i++;
        }
    }

    public int generateRandomWinningLuckyNumber() {
        Random rand = new Random();
        this.winningLuckyNumber = rand.nextInt(10) + 1;
        return winningLuckyNumber;
    }

    public void createBet(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber, int betMoney) {

        bet = new Bet(betMoney);
        bet.getChosenNumber(firstNumber);
        bet.getChosenNumber(secondNumber);
        bet.getChosenNumber(thirdNumber);
        bet.getChosenNumber(fourthNumber);

    }
   
    // creates Superbet
    public void createSuperBet(int fifthNumber, int moneyAfterBet) {

        sb = new SuperBet(fifthNumber, moneyAfterBet);

    }

    // get gain with Bet and SuperBet
    
    public int getGain(TypeBet type) {
        int gainAmount = 0;
        switch (type) {
            case BET:
                gainAmount = bet.computeGain(this);
                break;

            case SUPERBET:
                gainAmount = sb.computeGain(this);
                break;
        }

        return gainAmount;
    }

}
