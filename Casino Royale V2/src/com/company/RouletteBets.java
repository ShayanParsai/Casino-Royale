package com.company;

import javax.swing.*;
import java.util.Arrays;

public class RouletteBets {
    /**
     * Called from main, resets all the "Boolean[] bets" to false
     * And than it calls for resetAllTextFields() to reset the JTextFields in Main
     */
    public void setAllBetsToFalse(JTextField[] betOnArray,Boolean[] bets ) {
        Arrays.fill(bets, false);
        resetAllTextFields(betOnArray);
    }

    private void resetAllTextFields(JTextField[] betOnArray){
        for (JTextField textField : betOnArray) {
            textField.setText("");
        }
    }
}
