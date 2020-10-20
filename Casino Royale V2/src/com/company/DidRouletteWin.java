package com.company;

import java.util.Arrays;
import java.util.List;

public class DidRouletteWin {

    private final Integer[] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    private final List<Integer> redNumbers = Arrays.asList(red);
    private final Integer[] black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    public final List<Integer> blackNumbers = Arrays.asList(black);

    public int checkWin(int userCredit, int rouletteRollResult) {
        int tempCredit = userCredit;
        int tempTotal = 0;
        MyMultiplier multiplyByTwoFunction = (a) -> a*2;
        MyMultiplier multiplyByThreeFunction = (a) -> a*3;

        if (redNumbers.contains(rouletteRollResult) && RouletteBets.bets[0]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit; tempCredit = userCredit;
        }
        if (blackNumbers.contains(rouletteRollResult) && RouletteBets.bets[1]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit; tempCredit = userCredit;
        }
        if (rouletteRollResult == (0) && RouletteBets.bets[2]) {
            tempCredit *= 35; tempTotal += tempCredit; tempCredit = userCredit;
        }
        if((rouletteRollResult%2)!=0 && RouletteBets.bets[3]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit; tempCredit = userCredit;
        }
        if ((rouletteRollResult%2)==0 && RouletteBets.bets[4]){
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit; tempCredit = userCredit;
        }
        if (rouletteRollResult >18 && RouletteBets.bets[5]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit; tempCredit = userCredit;
        }
        if (rouletteRollResult <19 && RouletteBets.bets[6]) {
            tempCredit = multiplyByTwoFunction.multiply(tempCredit);
            tempTotal += tempCredit; tempCredit = userCredit;
        }
        if (rouletteRollResult <13 && RouletteBets.bets[7]) {
            tempCredit = multiplyByThreeFunction.multiply(tempCredit);
            tempTotal += tempCredit; tempCredit = userCredit;
        }
        if (rouletteRollResult >12 && rouletteRollResult <25 && RouletteBets.bets[8]) {
            tempCredit = multiplyByThreeFunction.multiply(tempCredit);
            tempTotal += tempCredit; tempCredit = userCredit;
        }
        if (rouletteRollResult > 24 && RouletteBets.bets[9]) {
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
