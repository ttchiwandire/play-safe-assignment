package com.playsafeholding.assignment.model;

import java.math.BigDecimal;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 22:52
 */
public class Bet {
    private String player;
    private String market;
    private BigDecimal amount;
    private BigDecimal winnings = new BigDecimal(0.00);
    private String outcome = "LOSE";

    public Bet(String player, String market, BigDecimal amount) {
        this.player = player;
        this.market = market;
        this.amount = amount;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public BigDecimal getWinnings() {
        return winnings;
    }

    public void setWinnings(BigDecimal winnings) {
        this.winnings = winnings;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
