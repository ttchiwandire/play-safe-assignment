package com.playsafeholding.assignment.services.roulette.helpers;

import java.util.Random;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 22:47
 */
public class WinningNumberGenerator {
    public static int generateWinningNumber() {
        Random r = new Random();
        int low = 1;
        int high = 37;
        int result = r.nextInt(high - low) + low;
        return result;
    }
}
