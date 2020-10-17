package com.company;

public class RouletteBets extends Main {

    static boolean BetOnGreen = false;
    static boolean BetOnBlack = false;
    static boolean BetOnRed = false;
    static boolean BetOnOdds = false;
    static boolean BetOnEvens = false;
    static boolean BetOnTopHalf = false;
    static boolean BetOnBottomHalf = false;
    static boolean BetOn1st = false;
    static boolean BetOn2nd = false;
    static boolean BetOn3rd = false;

    public void setAllBetsToFalse() {
        BetOnGreen = false;
        BetOnBlack = false;
        BetOnRed = false;
        BetOnOdds = false;
        BetOnEvens = false;
        BetOnTopHalf = false;
        BetOnBottomHalf = false;
        BetOn1st = false;
        BetOn2nd = false;
        BetOn3rd = false;
        resetAllTextFields();
    }

    public void resetAllTextFields(){
        betOnRedText.setText("");
        betOnBlackText.setText("");
        betOnGreenText.setText("");
        betOnOddsText.setText("");
        betOnEvensText.setText("");
        betOnTopHalfText.setText("");
        betOnBottomHalfText.setText("");
        betOn1stText.setText("");
        betOn2ndText.setText("");
        betOn3rdText.setText("");
    }
}