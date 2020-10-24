package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Main")
public class CasinoTest {

    @Test
    @DisplayName("Testing if roulette checkWin returns correct 2x Multiplier")
    void checkWin1() {
        RouletteMath checkIfWin = new RouletteMath();
        Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
        bets[0] = true; //BetOnRed
        int expectedReturn = 20;

        assertEquals(expectedReturn,checkIfWin.checkWin(10,1,bets));
    }

    @Test
    @DisplayName("Testing if roulette checkWin returns correct 3x Multiplier")
    void checkWin2() {
        RouletteMath checkIfWin = new RouletteMath();
        Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
        bets[7] = true; //BetOn1StHalf
        int expectedReturn = 30;

        assertEquals(expectedReturn,checkIfWin.checkWin(10,11,bets));
    }

    @Test
    @DisplayName("Testing if roulette checkWin returns correct 35x Multiplier")
    void checkWin3() {
        RouletteMath checkIfWin = new RouletteMath();
        Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
        bets[2] = true; //BetOnGreen
        int expectedReturn = 350;

        assertEquals(expectedReturn,checkIfWin.checkWin(10,0,bets));
    }
}