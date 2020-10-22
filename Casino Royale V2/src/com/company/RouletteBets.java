package com.company;

import javax.swing.*;
import java.util.Arrays;

public class RouletteBets {

    /**
     * This Array is public so we can set the booleans inside to true from main, when bets are placed
     */
    public static final Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
    // Red = 0 | Black = 1 | Green = 2 | Odds = 3 | Evens = 4
    // TopHalf = 5 | BotHalf = 6 | 1st = 7 | 2st = 8 | 3st = 9

    /**
     * Called from main, resets all the "Boolean[] bets" to false
     */
    public void setAllBetsToFalse(JTextField[] betOnArray) {
        Arrays.fill(bets, false);
        resetAllTextFields(betOnArray);
    }

    private void resetAllTextFields(JTextField[] betOnArray){
        for (JTextField textField : betOnArray) {
            textField.setText("");
        }
    }
}
