package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {

    //Red= 0 | Black= 1 | Green= 2 | Odds= 3 | Evens= 4 |TopHalf= 5 | BotHalf= 6 | 1st= 7 | 2st= 8 | 3st= 9
    private final Boolean[] bets = {false,false,false,false,false,false,false,false,false,false};
    private JTextField rouletteResultText;
    private int userCredits = 500;
    private int userBet = 0;

    private double throwDice() { return (int)(Math.random()*((7-1))+ (double) 1); }
    private double spinRoulette() { return (int)(Math.random()*((36))); }

    public static void main(String[] args) {
        Main program = new Main();
        program.StartLoginFrame();
    }

    private void StartLoginFrame() {
        PanelsAndFrames getFrame = new PanelsAndFrames();

        JPanel loginPanel = new JPanel();
        JFrame loginFrame = new JFrame("Dice Generator Login");
        getFrame.getPanelsAndFrames(loginPanel, loginFrame, 350,175);
        //=== Login Frame/Panel^ ===//

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameTextField = new JTextField(20);
        getFrame.getLabel(usernameLabel,loginPanel,10,20,80,25);
        getFrame.getTextField(usernameTextField,loginPanel,100,20,165,25);
        //=== Username Label & TextField^ ===//

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordTextField = new JPasswordField(20);
        getFrame.getLabel(passwordLabel,loginPanel,10,50,80,25);
        getFrame.getTextField(passwordTextField,loginPanel,100,50,165,25);
        //=== Password Label & TextField^ ===//

        JLabel loginMessageLabel = new JLabel("");
        getFrame.getLabel(loginMessageLabel,loginPanel,100,80,300,25);
        //=== Login Message^ ===//

        JButton loginButton = new JButton("Login");
        getFrame.getButton(loginButton,loginPanel,10,90,80,25);
        loginPanel.repaint();
        //=== LoginButton^ ===//

        loginButton.addActionListener(e1 -> {
            String userName = usernameTextField.getText();
            String passWord = passwordTextField.getText();
            if(userName.equals("") && passWord.equals("")) {
                loginFrame.setVisible(false);
                StartLobby(loginMessageLabel,loginFrame,passwordTextField);
            }
            else {
                loginMessageLabel.setText("Wrong username or password, try again");
            }
        });
    }

    private void StartLobby(JLabel loginMessage, JFrame loginFrame, JPasswordField passwordTextField) {
        PanelsAndFrames getFrames = new PanelsAndFrames();

        JPanel choicePanel = new JPanel();
        JFrame choiceFrame = new JFrame("Lobby");
        getFrames.getPanelsAndFrames(choicePanel, choiceFrame, 350, 175);
        //=== Choice Frame+Panel^ ===//

        JButton rouletteButton = new JButton("Roulette");
        JButton diceButton = new JButton("Dice 6 & 12");
        getFrames.getButton(rouletteButton,choicePanel,25,30,125,40);
        getFrames.getButton(diceButton,choicePanel,175,30,125,40);
        //=== Roulette/Dice Buttons^ ===//

        JButton logoutButton = new JButton("Logout");
        getFrames.getButton(logoutButton,choicePanel,115,85,90,35);
        logoutButton.addActionListener(e1 -> {

            choiceFrame.setVisible(false);
            loginFrame.setVisible(true);
            loginMessage.setText("");
            passwordTextField.setText("");
        });
        //=== Logout^ ===//

        rouletteButton.addActionListener(e2 -> {
            choiceFrame.setVisible(false);
            StartRoulette(choiceFrame);
        });

        diceButton.addActionListener(e3 -> {
            choiceFrame.setVisible(false);
            startDice(choiceFrame);
        });
    }

    private void startDice(JFrame choiceFrame) {
        PanelsAndFrames getFrames = new PanelsAndFrames();
        Font veryLargeFont = new Font("serif", Font.PLAIN,40);

        JPanel dicePanel = new JPanel();
        JFrame diceFrame = new JFrame("Dice");
        getFrames.getPanelsAndFrames(dicePanel, diceFrame,525,350);
        //=== Dice Frame+Panel^ ===//

        JTextField diceGameLogText = new JTextField(50);
        getFrames.getGameLogTextField(diceGameLogText,dicePanel,userCredits,50,180);
        //=== Dice GameLog Text Field^ ===//

        JTextField userRollTextField = new JTextField(50);
        JTextField houseRollTextField = new JTextField(50);
        getFrames.getTextField(userRollTextField,dicePanel,140,55,40,55);
        getFrames.getTextField(houseRollTextField,dicePanel,315,55,40,55);
        userRollTextField.setEditable(false);
        userRollTextField.setFont(veryLargeFont);
        houseRollTextField.setEditable(false);
        houseRollTextField.setFont(veryLargeFont);
        //=== Dice User&House TextFields^ ===//

        JLabel userLabel = new JLabel("You");
        JLabel vsLabel = new JLabel("VS");
        JLabel houseLabel = new JLabel("House");
        getFrames.getLabel(houseLabel,dicePanel,285,-20,125,90);
        getFrames.getLabel(vsLabel,dicePanel,220,35,90,90);
        getFrames.getLabel(userLabel,dicePanel,125,-20,90,90);
        userLabel.setFont(veryLargeFont);
        houseLabel.setFont(veryLargeFont);
        vsLabel.setFont(veryLargeFont);
        //=== Dice Labels^ ===//

        JTextField diceCurrentWagerText = new JTextField(20);
        getFrames.getCurrentWagerTextField(diceCurrentWagerText,dicePanel,335,265);
        //=== Dice CurrentWager TextField^ ===///

        JButton throwDiceButton = new JButton("Throw Dice");
        getFrames.getButton(throwDiceButton,dicePanel,50,130,400,40);
        throwDiceButton.addActionListener(e11 -> throwDice
                (userRollTextField,houseRollTextField,diceGameLogText));
        //=== Throw Dice Button^ ===//

        JButton diceReduceWageButton = new JButton("Reduce Wage by 10");
        JButton diceRaiseWageButton = new JButton("Raise Wage by 10");
        getFrames.getButton(diceReduceWageButton,dicePanel,15,265,150,40);
        getFrames.getButton(diceRaiseWageButton,dicePanel,175,265,150,40);
        diceCurrentWagerText.setText(String.valueOf(userBet));
        diceReduceWageButton.addActionListener(e13 -> {
            if (userBet > 9) {
                userBet -= 10;
                diceCurrentWagerText.setText(String.valueOf(userBet));
            }
        });
        diceRaiseWageButton.addActionListener(e13 -> {
            userBet += 10;
            diceCurrentWagerText.setText(String.valueOf(userBet));
        });
        //=== Dice Raise/LowerWager Button^ ===//

        JButton diceExitToLobbyButton = new JButton("Lobby");
        getFrames.getButton(diceExitToLobbyButton,dicePanel,400,265,90,40);
        diceExitToLobbyButton.addActionListener(e14 -> {
            diceFrame.setVisible(false);
            choiceFrame.setVisible(true);
        });
        //=== Exit to lobby^ ===//
    }

    private void StartRoulette(JFrame choiceFrame) {
        RouletteBets allBets = new RouletteBets();
        PanelsAndFrames getFrames = new PanelsAndFrames();

        JPanel roulettePanel = new JPanel();
        JFrame rouletteFrame = new JFrame("Roulette");
        getFrames.getPanelsAndFrames(roulettePanel, rouletteFrame,525,550);
        //=== Roulette Frame+Panel^ ===//

        JButton betOnRedButton = new JButton("Red");
        JTextField betOnRedText = new JTextField(50);
        getFrames.getButton(betOnRedButton,roulettePanel,15,30,100,40);
        getFrames.getTextField(betOnRedText,roulettePanel,120,30,120,40);
        betOnRedButton.addActionListener(e1 -> {
            bets[0] = true;
            betOnRedText.setText("Your bet is on Red");
        });
        //=== Red Button&Text Field^ ===//

        JButton betOnBlackButton = new JButton("Black");
        JTextField betOnBlackText = new JTextField(50);
        getFrames.getButton(betOnBlackButton,roulettePanel,15,90,100,40);
        getFrames.getTextField(betOnBlackText,roulettePanel,120,90,120,40);
        betOnBlackButton.addActionListener(e2 -> {
            bets[1] = true;
            betOnBlackText.setText("Your bet is on Black");
        });
        //=== Black Button&Text Field^ ===//

        JButton betOnGreenButton = new JButton("Green");
        JTextField betOnGreenText = new JTextField(50);
        getFrames.getButton(betOnGreenButton,roulettePanel,15,150,100,40);
        getFrames.getTextField(betOnGreenText,roulettePanel,120,150,120,40);
        betOnGreenButton.addActionListener(e3 -> {
            bets[2] = true;
            betOnGreenText.setText("Your bet is on green");
        });
        //=== Green Button&Text Field^ ===//

        JButton betOnOddsButton = new JButton("Odds");
        JTextField betOnOddsText = new JTextField(50);
        getFrames.getButton(betOnOddsButton,roulettePanel,15,210,100,40);
        getFrames.getTextField(betOnOddsText,roulettePanel,120,210,120,40);
        betOnOddsButton.addActionListener(e4 -> {
            bets[3] = true;
            betOnOddsText.setText("Your bet is on Odds");
        });
        //=== Odds Button&Text Field^ ===//

        JButton betOnEvensButton = new JButton("Evens");
        JTextField betOnEvensText = new JTextField(50);
        getFrames.getButton(betOnEvensButton,roulettePanel,15,270,100,40);
        getFrames.getTextField(betOnEvensText,roulettePanel,120,270,120,40);
        betOnEvensButton.addActionListener(e5 -> {
            bets[4] = true;
            betOnEvensText.setText("Your bet is on Evens");
        });
        //=== Evens Button&Text Field^ ===//

        JButton betOnTopHalfButton = new JButton("Top half");
        JTextField betOnTopHalfText = new JTextField(50);
        getFrames.getButton(betOnTopHalfButton,roulettePanel,375,30,100,40);
        getFrames.getTextField(betOnTopHalfText,roulettePanel,247,30,123,40);
        betOnTopHalfButton.addActionListener(e6 -> {
            bets[5] = true;
            betOnTopHalfText.setText("Your bet is on top half");
        });
        //=== Top½ Button&Text Field^ ===//

        JButton betOnBottomHalfButton = new JButton("Bottom half");
        JTextField betOnBottomHalfText = new JTextField(50);
        getFrames.getButton(betOnBottomHalfButton,roulettePanel,375,90,100,40);
        getFrames.getTextField(betOnBottomHalfText,roulettePanel,247,90,123,40);
        betOnBottomHalfButton.addActionListener(e7 -> {
            bets[6] = true;
            betOnBottomHalfText.setText("Your bet is on bot half");
        });
        //=== Bottom½ Button&Text Field^ ===//

        JButton betOn1stButton = new JButton("1st");
        JTextField betOn1stText = new JTextField(50);
        getFrames.getButton(betOn1stButton,roulettePanel,375,150,100,40);
        getFrames.getTextField(betOn1stText,roulettePanel,247,150,123,40);
        betOn1stButton.addActionListener(e8 -> {
            bets[7] = true;
            betOn1stText.setText("Your bet is on 1st 12");
        });
        //=== 1st Button&Text Field^ ===//

        JButton betOn2ndButton = new JButton("2nd");
        JTextField betOn2ndText = new JTextField(50);
        getFrames.getButton(betOn2ndButton,roulettePanel,375,210,100,40);
        getFrames.getTextField(betOn2ndText,roulettePanel,247,210,123,40);
        betOn2ndButton.addActionListener(e9 -> {
            bets[8] = true;
            betOn2ndText.setText("Your bet is on 2nd 12");
        });
        //=== 2nd Button&Text Field^ ===//

        JButton betOn3rdButton = new JButton("3rd");
        JTextField betOn3rdText = new JTextField(50);
        getFrames.getButton(betOn3rdButton,roulettePanel,375,270,100,40);
        getFrames.getTextField(betOn3rdText,roulettePanel,247,270,123,40);
        betOn3rdButton.addActionListener(e10 -> {
            bets[9] = true;
            betOn3rdText.setText("Your bet is on 3rd 12");
        });
        //=== 3rd Button&Text Field^ ===//

        JTextField[] betOnArray = {betOnRedText,betOnBlackText,betOnGreenText,betOnOddsText,betOnEvensText,
        betOnTopHalfText,betOnBottomHalfText,betOn1stText,betOn2ndText,betOn3rdText};
        allBets.setAllBetsToFalse(betOnArray,bets);
        //=== Array betOnJTextFrames^ ===//

        JButton resetAllBetsButton = new JButton("Reset all bets");
        getFrames.getButton(resetAllBetsButton,roulettePanel,190,0,125,25);
        resetAllBetsButton.addActionListener(e0 -> allBets.setAllBetsToFalse(betOnArray,bets));
        //=== Reset All Bets Button^ ===//

        JTextField rouletteGameLogText = new JTextField(50);
        getFrames.getGameLogTextField(rouletteGameLogText,roulettePanel,userCredits,15,380);
        //=== GameLog Text Field^ ===//

        JButton spinWheelButton = new JButton("Spin Wheel");
        getFrames.getButton(spinWheelButton,roulettePanel,15,330,460,40);
        spinWheelButton.addActionListener(e11 -> calculateRouletteResults(betOnArray,rouletteGameLogText));
        //=== spinWheel Button^ ===//

        rouletteResultText = new JTextField(20);
        getFrames.getTextField(rouletteResultText,roulettePanel,425,380,50,50);
        Font thickFont = new Font("SansSerif", Font.BOLD, 40);
        rouletteResultText.setFont(thickFont);
        rouletteResultText.setEditable(false);
        //=== Roulette Result Text Field^ ===//

        JTextField rouletteCurrentWagerText = new JTextField(20);
        getFrames.getCurrentWagerTextField(rouletteCurrentWagerText,roulettePanel,335,465);
        //=== CurrentWager TextField^ ===///

        JButton rouletteReduceWageButton = new JButton("Reduce Wage by 10");
        JButton rouletteRaiseWageButton = new JButton("Raise Wage by 10");
        getFrames.getButton(rouletteReduceWageButton,roulettePanel,15,465,150,40);
        getFrames.getButton(rouletteRaiseWageButton,roulettePanel,175,465,150,40);
        rouletteCurrentWagerText.setText(String.valueOf(userBet));
        rouletteReduceWageButton.addActionListener(e13 -> {
            if (userBet > 9) {
                userBet -= 10;
                rouletteCurrentWagerText.setText(String.valueOf(userBet));
            }
        });
        rouletteRaiseWageButton.addActionListener(e13 -> {
            userBet += 10;
            rouletteCurrentWagerText.setText(String.valueOf(userBet));
        });
        //=== Raise/LowerWager Button^ ===//

        JButton rouletteExitToLobbyButton = new JButton("Lobby");
        getFrames.getButton(rouletteExitToLobbyButton,roulettePanel,400,465,90,40);
        rouletteExitToLobbyButton.addActionListener(e14 -> {
            rouletteFrame.setVisible(false);
            choiceFrame.setVisible(true);
        });
        //=== Exit to lobby Button^ ===//
    }

    private void calculateRouletteResults(JTextField[] betOnArray, JTextField rouletteGameLogText) {
        RouletteBets allBets = new RouletteBets();
        RouletteMath checkIfWin = new RouletteMath();

        // Makes sure the user has enough credits for multiple bets
        int tempUserBet = 0;
        for (Boolean aBoolean : bets) {
            if (aBoolean)
                tempUserBet += userBet;
        }

        // Goes on if the user affords the bet or bets
        if (userCredits >= tempUserBet) {

            // Spins the spinRoulette and String/Int the result, sets the colour of the result
            int rouletteRollResult = (int) spinRoulette();
            String x = Integer.toString(rouletteRollResult);
            rouletteResultText.setText(x);
            setResultColour(rouletteRollResult);

            // Check how many bets were placed and deducts bet amount per bet
            for (Boolean bet : bets) {
                if (bet)
                    userCredits -= userBet;
            }

            // Sends the result of spinRoulette and bet to calculate win/loss
            int userTempValue = checkIfWin.checkWin(userBet,rouletteRollResult,bets);
            userCredits += userTempValue;

            // set result text
            setResultText(userTempValue,rouletteGameLogText);

            // check if user have enough funds
        } else if (userCredits > 0) {
            rouletteGameLogText.setText("Insufficient funds, please lower wager");
        } else {
            rouletteGameLogText.setText("Insufficient funds, please refill balance");
        }
        allBets.setAllBetsToFalse(betOnArray,bets);
    }

    private void setResultColour(int roll) {
        if (roll == 0) {
            rouletteResultText.setBackground(Color.green);
        } else if (Arrays.asList(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35).contains(roll)) {
            rouletteResultText.setBackground(Color.gray);
        } else {
            rouletteResultText.setBackground(Color.red);
        }
    }

    private void setResultText(int tempValue, JTextField rouletteGameLogText) {
        if (tempValue > userBet) {
            rouletteGameLogText.setText("You won " + tempValue + " credits, your new total is: " + userCredits);
        } else if (!Arrays.asList(bets).contains(true)) {
            rouletteGameLogText.setText("No bets found, your total is still : " + userCredits);
        } else {
            rouletteGameLogText.setText("You lost " + userBet + " credits, your total is now: " + userCredits);
        }
    }

    private void throwDice(JTextField user, JTextField house, JTextField diceGameLogText) {
        if (userCredits >= userBet){
            int userRoll = (int) throwDice();
            int houseRoll = (int) throwDice();
            user.setText(String.valueOf(userRoll));
            house.setText(String.valueOf(houseRoll));
            calculateDiceWinOrLoss(userRoll,houseRoll,diceGameLogText);
        } else if(userCredits > 0) {
            diceGameLogText.setText("Insufficient funds, please lower wager");
        } else {
            diceGameLogText.setText("Insufficient funds, please refill balance");
        }
    }

    private void calculateDiceWinOrLoss(int userRoll, int houseRoll,JTextField diceGameLogText) {
        if (userRoll > houseRoll) {
            userCredits += userBet;
            diceGameLogText.setText("You won " +userBet+ " your total is now: " +userCredits);
        } else if (userRoll == houseRoll) {
            userCredits -= userBet/10;
            diceGameLogText.setText("You lost 10% of the wage, your total is now: " + userCredits);
        } else {
            userCredits -= userBet;
            diceGameLogText.setText("You lost " +userBet+ " your total is now: " +userCredits);
        }
    }
}
