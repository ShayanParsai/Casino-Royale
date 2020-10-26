package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Main")
public class CasinoTest {

    @Test
    @DisplayName("Testing if roulette checkWin returns correct 2x Multiplier")
    void checkWin1() {
        RouletteMath checkIfWin = new RouletteMath();
        Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
        bets[0] = true;

        assertEquals(20,checkIfWin.checkWin(10,1,bets));
    }

    @Test
    @DisplayName("Testing if roulette checkWin returns correct 3x Multiplier")
    void checkWin2() {
        RouletteMath checkIfWin = new RouletteMath();
        Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
        bets[7] = true;

        assertEquals(30,checkIfWin.checkWin(10,11,bets));
    }

    @Test
    @DisplayName("Testing if roulette checkWin returns correct 35x Multiplier")
    void checkWin3() {
        RouletteMath checkIfWin = new RouletteMath();
        Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
        bets[2] = true;

        assertEquals(350,checkIfWin.checkWin(10,0,bets));
    }

    @Test
    @DisplayName("Testing if roulette correctly returns no win Miltiplier on all outcomes")
    void checkWin4() {
        RouletteMath checkIfWin = new RouletteMath();
        Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
        for (int i=0; i < 37; i++){
            assertEquals(0,checkIfWin.checkWin(10,i,bets));
        }
    }

    @Test
    @DisplayName("Testing if setAllBetsToFalse() Correctly sets the booleans to false")
    void setAllBetsToFalse() {
        RouletteBetsReset checkIfWin = new RouletteBetsReset();
        JTextField[] betOnArray = {};
        Boolean[] bets = {true,true,true,true,true,true,true,true,true,true};

        checkIfWin.setAllBetsToFalse(betOnArray,bets);

        for (Boolean bet : bets) {
            assertFalse(bet);
        }
    }
}