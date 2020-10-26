package com.company;

import javax.swing.*;
import java.util.Arrays;

public class RouletteBetsReset {
    /**
     * This method is called in main to set betting booleans and textfields to reset them
     * @param betOnArray Takes in TextFields, to reset them in resetAllTextFields()
     * @param bets Takes in Booleans to set them to false
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
