package com.playsafeholding.assignment.services.roulette;

import com.playsafeholding.assignment.model.Bet;
import com.playsafeholding.assignment.services.roulette.helpers.InputReader;
import com.playsafeholding.assignment.services.roulette.helpers.NewBetGenerator;
import com.playsafeholding.assignment.services.roulette.helpers.WinningNumberGenerator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 22:46
 */
public class RouletteService {
    private static int winningNumber;
    private static final int SECONDS_TO_GENERATE_NEW_NUMBER = 30;


    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        //Getting a list of players from a file passed in via the commandline
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        System.out.println("Welcome and Goodluck!");


        //Playing Game
        String playAgain = playGame();
        if (playAgain.equalsIgnoreCase("Y")) {
            main(args);
        }

        System.out.println("Thanks for playing, see you next time!");
        System.exit(0);
    }

    static String playGame() throws InterruptedException {
        long time = System.currentTimeMillis();

        Set<Bet> bets = new HashSet<>();


        bets = (InputReader.readInput(bets));
        String betAgain = NewBetGenerator.anotherBet();
        if (betAgain.equalsIgnoreCase("Y")) {
            bets = InputReader.readInput(bets);
        }


        //Waiting 30 seconds for the draw to complete
        time = System.currentTimeMillis() - time;
        Thread.sleep(30000 - time);

        //Generating winning numbers at 30 seconds intervals
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, SECONDS_TO_GENERATE_NEW_NUMBER * 1000);

        Thread.sleep(2000);

        //Settling bets
        for (Bet bet : bets) {
            if ("EVEN".equalsIgnoreCase(bet.getMarket())) {
                if (winningNumber % 2 == 0) {
                    bet.setWinnings(bet.getAmount().multiply(new BigDecimal(2)));
                    bet.setOutcome("WIN");
                }
            } else if ("ODD".equalsIgnoreCase(bet.getMarket())) {
                if (winningNumber % 2 == 1) {
                    bet.setWinnings(bet.getAmount().multiply(new BigDecimal(2)));
                    bet.setOutcome("WIN");
                }
            } else {
                if (winningNumber == Integer.parseInt(bet.getMarket())) {
                    bet.setWinnings(bet.getAmount().multiply(new BigDecimal(36)));
                    bet.setOutcome("WIN");
                }
            }
        }

        //Output of bet results
        System.out.println("===============================================================================");
        System.out.println("Number:    " + winningNumber);
        System.out.println("Player     Bet    Outcome    Winnings");
        for (Bet b : bets) {
            System.out.println(b.getPlayer() + "      " + b.getMarket() + "     " + b.getOutcome() + "        " + b.getWinnings());
        }
        System.out.println("===============================================================================");
        Scanner consoleReader = new Scanner(System.in);
        System.out.print("Play Again?  Y/N");
        return consoleReader.nextLine();
    }


    static class RemindTask extends TimerTask {
        public void run() {
            winningNumber = WinningNumberGenerator.generateWinningNumber();
        }
    }
}

