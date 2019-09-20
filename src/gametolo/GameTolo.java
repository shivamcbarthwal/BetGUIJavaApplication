/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametolo;

import gametolo.Tolo.TypeBet;
import java.util.Scanner;

/**
 *
 * @author Shivam
 */
public class GameTolo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Accepting 4 numbers from user    
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your 4 numbers of your choice\n");

        int chosenNumber1 = input.nextInt();
        int chosenNumber2 = input.nextInt();
        int chosenNumber3 = input.nextInt();
        int chosenNumber4 = input.nextInt();

        System.out.println("Enter the money you wish to bet\n");
        // Accepting Bet Money Input by player   
        int betMoney = input.nextInt();

        // Create tolo object
        Tolo tolo = new Tolo();

        // Create Bet with 4 user numbers and bet amount
        tolo.createBet(chosenNumber1, chosenNumber2, chosenNumber3, chosenNumber4, betMoney);

        // write gain obtained after
        int earnedMoneyBet = tolo.getGain(TypeBet.BET);
        System.out.println("Gain After Bet: " + earnedMoneyBet);

        // Accepting player choice input to play further for SuperBet
        Scanner choiceInput = new Scanner(System.in);
        System.out.println("Do you want to play further with Superbet: Yes or No\n");

        String choice = choiceInput.nextLine();

        if (choice.equalsIgnoreCase("Yes")) {
            System.out.println("Enter the fifth Number you wish to play with\n");
            int chosenNumber5 = input.nextInt();

            // creating SuperBet with fifth number
            tolo.createSuperBet(chosenNumber5, earnedMoneyBet);

            // Writing gain after Super Bet
            int earnedMoneySuperBet = tolo.getGain(TypeBet.SUPERBET);
            System.out.println(earnedMoneySuperBet);
        } // expression to write the gain with normal bet if player doesn't opt for SuperBet
        
        else {
            System.out.println("You have earned: " + earnedMoneyBet);
        }

    }

}
