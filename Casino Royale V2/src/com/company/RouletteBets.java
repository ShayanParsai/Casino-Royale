package com.company;

import java.util.Arrays;

public class RouletteBets {

    public static final Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
    // Red = 0 | Black = 1 | Green = 2 | Odds = 3 | Evens = 4
    // TopHalf = 5 | BotHalf = 6 | 1st = 7 | 2st = 8 | 3st = 9

    protected void setAllBetsToFalse(Main main) {
        Arrays.fill(bets, false);
        resetAllTextFields(main);
    }

    private void resetAllTextFields(Main main){
        main.betOnRedText.setText("");
        main.betOnBlackText.setText("");
        main.betOnGreenText.setText("");
        main.betOnOddsText.setText("");
        main.betOnEvensText.setText("");
        main.betOnTopHalfText.setText("");
        main.betOnBottomHalfText.setText("");
        main.betOn1stText.setText("");
        main.betOn2ndText.setText("");
        main.betOn3rdText.setText("");
    }
}
