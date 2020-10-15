package com.company;

import java.util.Arrays;
import java.util.List;

public class DidRouletteWin extends Main {

    static Integer[] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    static List<Integer> redNumbers = Arrays.asList(red);
    static Integer[] black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    static List<Integer> blackNumbers = Arrays.asList(black);

    public static int checkWin(int userCredit, int rouletteRollResult) {
        int tempCredit = userCredit;
        int tempTotal = 0;

        if (rouletteRollResult == (37) && RouletteBets.BetOnGreen) {
            tempCredit *= 35;
            tempTotal =+ tempCredit;
            tempCredit /= 35;
        }
        if (rouletteRollResult <19 && RouletteBets.BetOnTopHalf) {
            tempCredit *= 2;
            tempTotal =+ tempCredit;
            tempCredit /= 2;
        }
        if (rouletteRollResult >18 && RouletteBets.BetOnBottomHalf) {
            tempCredit *= 2;
            tempTotal =+ tempCredit;
            tempCredit /= 2;
        }
        if (rouletteRollResult <12 && RouletteBets.BetOn1st) {
            tempCredit *= 3;
            tempTotal =+ tempCredit;
            tempCredit /= 3;
        }
        if (rouletteRollResult >12 && roulette() <26 && RouletteBets.BetOn2nd) {
            tempCredit *= 3;
            tempTotal =+ tempCredit;
            tempCredit /= 3;
        }
        if (rouletteRollResult <24 && RouletteBets.BetOn3rd) {
            tempCredit *= 3;
            tempTotal =+ tempCredit;
            tempCredit /= 3;
        }
        if (redNumbers.contains(rouletteRollResult) && RouletteBets.BetOnRed) {
            tempCredit *= 2;
            tempTotal =+ tempCredit;
            tempCredit /= 2;
        }
        if (blackNumbers.contains(rouletteRollResult) && RouletteBets.BetOnBlack) {
            tempCredit *= 2;
            tempTotal =+ tempCredit;
            tempCredit /= 2;
        }
        if((rouletteRollResult%2)==0 && RouletteBets.BetOnEvens) {
            tempCredit *= 2;
            tempTotal =+ tempCredit;
            tempCredit /= 2;
        }
        if ((rouletteRollResult%2)!=0 && RouletteBets.BetOnOdds){
            tempCredit *= 2;
            tempTotal =+ tempCredit;
        }
        userCredit = tempTotal;
        return userCredit;
    }
}