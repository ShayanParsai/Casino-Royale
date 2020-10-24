package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Main")
public class CasinoTest {

    @Test
    @DisplayName("Testing if checkWin returns correct 2x Multiplier")
    void checkWin1() {
        RouletteMath checkIfWin = new RouletteMath();
        RouletteBets.bets[0] = true;
        int expectedReturn = 20;

        assertEquals(expectedReturn,checkIfWin.checkWin(10,1));
    }

    @Test
    @DisplayName("Testing if checkWin returns correct 3x Multiplier")
    void checkWin2() {
        RouletteMath checkIfWin = new RouletteMath();
        RouletteBets.bets[0] = false;
        RouletteBets.bets[7] = true;
        int expectedReturn = 30;

        assertEquals(expectedReturn,checkIfWin.checkWin(10,11));
    }

    @Test
    @DisplayName("Testing if checkWin returns correct 35x Multiplier")
    void checkWin3() {
        RouletteMath checkIfWin = new RouletteMath();
        RouletteBets.bets[7] = false;
        RouletteBets.bets[2] = true;
        int expectedReturn = 350;

        assertEquals(expectedReturn,checkIfWin.checkWin(10,0));
    }
}