package com.playsafeholding.assignment.services.roulette.helpers;

import com.playsafeholding.assignment.model.Bet;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 22:50
 */
public class InputReader {

    public static Set<Bet> readInput(Set<Bet> bets) {
        Scanner consoleReader = new Scanner(System.in);
        System.out.print("Enter your name, bet and amount separated my space: ");
        String userInput = consoleReader.nextLine();
        String[] userBettingDetails = userInput.split(" ");
        String name = userBettingDetails[0];
        String market = userBettingDetails[1];
        String amount = userBettingDetails[2];
        bets.add(new Bet(name, market, new BigDecimal(amount)));
        return bets;
    }
}
