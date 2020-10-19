package com.company;

public class RouletteBets {

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

    protected void setAllBetsToFalse() {
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

    private void resetAllTextFields(){
        Main.betOnRedText.setText("");
        Main.betOnBlackText.setText("");
        Main.betOnGreenText.setText("");
        Main.betOnOddsText.setText("");
        Main.betOnEvensText.setText("");
        Main.betOnTopHalfText.setText("");
        Main.betOnBottomHalfText.setText("");
        Main.betOn1stText.setText("");
        Main.betOn2ndText.setText("");
        Main.betOn3rdText.setText("");
    }
}