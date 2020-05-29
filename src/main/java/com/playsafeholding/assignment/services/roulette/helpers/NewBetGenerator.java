package com.playsafeholding.assignment.services.roulette.helpers;

import java.util.Scanner;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 22:49
 */
public class NewBetGenerator {

    public static String anotherBet() {
        Scanner consoleReader = new Scanner(System.in);
        System.out.print("Place Another Bet?  Y/N");
        return consoleReader.nextLine();
    }
}
