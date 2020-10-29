package com.company;

import java.util.Arrays;
import java.util.List;

public class RouletteMath {

    private final Integer[] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    private final List<Integer> redNumbers = Arrays.asList(red);
    private final Integer[] black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    private final List<Integer> blackNumbers = Arrays.asList(black);
    /**
     * This method takes in the value of the users bet or bets, and also the result of the roulette spin,
     * it compares the result of the spin with all the possible win conditions, than it checks if the user
     * has bet on that winning condition, if the winning condition is true, and the user has placed a bet, it starts
     * the calculations to multiply the amount bet, with the amount inside the winning condition
     * @param userCredit Takes in the amount that the user bets/sends in
     * @param rouletteRollResult Takes in the result of the RNG number generated in main
     * @param bets Takes in the Array of bets, to compare them in the if statements
     * @return Returns the result of how much we won, IF we won
     */
    public int checkWin(int userCredit, int rouletteRollResult,Boolean[] bets) {
        int tempCredit = userCredit;
        int tempTotal = 0;
        MyMultiplier multiplyByTwoFunction = (a) -> a*2;
        MyMultiplier multiplyByThreeFunction = (a) -> a*3;

        if (redNumbers.contains(rouletteRollResult) && bets[0]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit;
            tempCredit = userCredit;
        }
        if (blackNumbers.contains(rouletteRollResult) && bets[1]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit;
            tempCredit = userCredit;
        }
        if (rouletteRollResult == (0) && bets[2]) {
            tempCredit *= 35; tempTotal += tempCredit; tempCredit = userCredit;
        }
        if((rouletteRollResult%2)!=0 && bets[3]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit;
            tempCredit = userCredit;
        }
        if ((rouletteRollResult%2)==0 && bets[4]){
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit;
            tempCredit = userCredit;
        }
        if (rouletteRollResult >18 && bets[5]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit;
            tempCredit = userCredit;
        }
        if (rouletteRollResult <19 && bets[6]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit;
            tempCredit = userCredit;
        }
        if (rouletteRollResult <13 && bets[7]) {
            tempCredit = multiplyByThreeFunction.multiply(tempCredit);
            tempTotal += tempCredit;
            tempCredit = userCredit;
        }
        if (rouletteRollResult >12 && rouletteRollResult <25 && bets[8]) {
            tempCredit = multiplyByThreeFunction.multiply(tempCredit);
            tempTotal += tempCredit;
            tempCredit = userCredit;
        }
        if (rouletteRollResult > 24 && bets[9]) {
            tempCredit = multiplyByThreeFunction.multiply(tempCredit);
            tempTotal += tempCredit;
        }
        userCredit =+ tempTotal;
        return userCredit;
    }

    private interface MyMultiplier {
        int multiply(int a);
    }
}