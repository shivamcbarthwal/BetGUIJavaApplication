/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametolo;

import java.util.ArrayList;
import java.util.Random;

/**
 * x
 *
 * @author Shivam
 */
public class Bet {

    // ArrayList for chosen Numbers, winning Numbers
    public ArrayList<Integer> numbers;
    int betMoney;
    public ArrayList<Integer> winningNumbers;

    public Bet(int betMoney) {
        this.betMoney = betMoney;
        this.winningNumbers = new ArrayList<Integer>();
        this.numbers = new ArrayList<Integer>();
        winningNumbers();
    }

    public void getChosenNumber(int chosenNumber) {
        numbers.add(chosenNumber);

    }

    // set good numbers
    public void winningNumbers() {

// The block of code below has been commented as it is impossible to have chosen numbers same as random numbers
// to run in random setting,uncomment the code from line( 40 - 49) and delete the line (51 - 54)
//     Random rand = new Random();
//     int i = 0;
//     while (i < 4) {
//         int goodNumber = rand.nextInt(20) + 1;
//         if(winningNumbers.contains(goodNumber) == true) {
//             return;
//         }
//         winningNumbers.add(goodNumber);
//         i++;
//     }
// winningNumbers are set up manually to match some of the chosen numbers and avoid gain as 0 
        winningNumbers.add(1);
        winningNumbers.add(5);
        winningNumbers.add(15);
        winningNumbers.add(20);
    }

    // get winning Numbers array list
    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    // compute gain for normal Bet
    public int computeGain(Tolo t) {
        int matchingnumbersCount = 0;
        int earnedAmount = 0;

        for (int i = 0; i < winningNumbers.size(); i++) {
            if (numbers.contains(winningNumbers.get(i)) != false) {
                matchingnumbersCount++;
            }
        }

        if (matchingnumbersCount == 3) {
            earnedAmount = 5 * betMoney;
        } else if (matchingnumbersCount == 4) {
            earnedAmount = 50 * betMoney;
        } else {
            earnedAmount = 0;

        }
        return earnedAmount;
    }

}
