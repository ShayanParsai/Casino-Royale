package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<String> DiceSixArrayList = new ArrayList<>();
    public static ArrayList<String> DiceTwelveArrayList = new ArrayList<>();
    private static JTextField usernameTextField;
    private static JTextField diceSixResult;
    private static JTextField diceTwelveResult;
    private static JTextField savedDiceTextField6;
    private static JTextField savedDiceTextField12;
    private static JTextField rouletteResult;
    private static JPasswordField passwordTextField;
    private static JLabel loginMessage;
    private static JFrame loginFrame;

    static double D6() {
        return (int)(Math.random()*((7-1))+ (double) 1);
    }
    static double D12() {
        return (int)(Math.random()*((13-1))+ (double) 1);
    }
    static double Roulette() {
        return (int)(Math.random()*((38-1))+ (double) 1);
    }

    public static void main(String[] args) {
        StartLoginFrame();
    }

    public static void StartLoginFrame() {

        JPanel loginPanel = new JPanel();
        loginFrame = new JFrame("Dice Generator Login");
        loginFrame.setSize(400,200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.add(loginPanel);
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.getHSBColor(0,20,202));
        //=== Login Frame/Panel^ ===//

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds (10,20,80,25);
        loginPanel.add(usernameLabel);
        usernameTextField = new JTextField(20);
        usernameTextField.setBounds(100,20,165,25);
        loginPanel.add(usernameTextField);
        //=== Username^ ===//

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds (10,50,80,25);
        loginPanel.add(passwordLabel);
        passwordTextField = new JPasswordField(20);
        passwordTextField.setBounds(100,50,165,25);
        loginPanel.add(passwordTextField);
        //=== Password^ ===//

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10,80,80,25);
        loginPanel.add(loginButton);
        //=== Button^ ===//

        loginMessage = new JLabel("");
        loginMessage.setBounds(100,80,300,25);
        loginPanel.add(loginMessage);
        loginFrame.setVisible(true);
        //=== Login Message^ ===//

        loginButton.addActionListener(e1 -> {
            String userName = usernameTextField.getText();
            String passWord = passwordTextField.getText();
            if(userName.equals("") && passWord.equals("")) {
                loginFrame.setVisible(false);
                StartLobby();
            }
            else {
                loginMessage.setText("Wrong username or password, try again");
            }
        });
    }

    public static void StartLobby() {
        JPanel choicePanel = new JPanel();
        JFrame choiceFrame = new JFrame("Casino Royale");
        choiceFrame.setVisible(true);
        choiceFrame.setSize(350,175);
        choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choiceFrame.setLocationRelativeTo(null);
        choiceFrame.add(choicePanel);
        choicePanel.setLayout(null);
        choicePanel.setBackground(Color.getHSBColor(0,20,202));
        //=== Choice Frame+Panel^ ===//

        JButton rouletteButton = new JButton("Roulette");
        JButton diceButton = new JButton("Dice 6 & 12");
        rouletteButton.setBounds(25,50,125,40);
        diceButton.setBounds(175,50,125,40);
        choicePanel.add(rouletteButton);
        choicePanel.add(diceButton);
        //=== Roulette/Dice Buttons^ ===//

        rouletteButton.addActionListener(e1 -> {
            choiceFrame.setVisible(false);
            StartRoulette();
        });

        diceButton.addActionListener(e2 -> {
            choiceFrame.setVisible(false);
            StartDice();
        });
    }

    public static void StartDice() {
        JPanel dicePanel = new JPanel();
        JFrame diceFrame = new JFrame("Dice");
        PanelsAndFrames.getPanelsAndFrames(dicePanel, diceFrame);
        //=== Dicer Frame+Panel^ ===//

        JButton rollDiceSix = new JButton("Roll 1-6");
        rollDiceSix.setBounds(15,30,100,40);
        diceSixResult = new JTextField(20);
        diceSixResult.setBounds(155,30,100,40);
        dicePanel.add(diceSixResult);
        dicePanel.add(rollDiceSix);
        rollDiceSix.addActionListener(e1 -> {

            String x = Integer.toString((int) D6());
            diceSixResult.setText(x);
            DiceSixArrayList.add(x);
        });
        //=== Dice 1-6^ ===//

        JButton rollDiceTwelve = new JButton("Roll 1-12");
        rollDiceTwelve.setBounds(15,100,100,40);
        diceTwelveResult = new JTextField(20);
        diceTwelveResult.setBounds(155,100,100,40);
        dicePanel.add(diceTwelveResult);
        dicePanel.add(rollDiceTwelve);
        rollDiceTwelve.addActionListener(e2 -> {

            String x = Integer.toString((int) D12());
            diceTwelveResult.setText(x);
            DiceTwelveArrayList.add(x);
        });
        //=== Dice 1-12^ ===//

        JButton printSavedButton = new JButton("Print saved rolls");
        printSavedButton.setBounds(15,187,145,40);
        savedDiceTextField6 = new JTextField(100);
        savedDiceTextField6.setBounds(175,167,250,40);
        dicePanel.add(savedDiceTextField6);
        savedDiceTextField12 = new JTextField(100);
        savedDiceTextField12.setBounds(175,204,250,40);
        dicePanel.add(savedDiceTextField12);
        dicePanel.add(printSavedButton);
        savedDiceTextField6.setText("(D6) :");
        savedDiceTextField12.setText("(D12):");
        printSavedButton.addActionListener(e3 -> {

            Collections.sort(DiceSixArrayList);
            Collections.sort(DiceTwelveArrayList);
            String x = DiceSixArrayList.toString();
            String y = DiceTwelveArrayList.toString();
            savedDiceTextField6.setText("(D6) :  " + x);
            savedDiceTextField12.setText("(D12): " + y);
        });
        //=== Print Saved Rolls^ ===//

        JButton deleteRollsButton = new JButton("Delete rolls");
        deleteRollsButton.setBounds(15,285,100,35);
        dicePanel.add(deleteRollsButton);
        deleteRollsButton.addActionListener(e4 -> {

            DiceSixArrayList.clear();
            DiceTwelveArrayList.clear();
            savedDiceTextField6.setText("(D6) :");
            savedDiceTextField12.setText("(D12):");
        });
        //=== Delete rolls^ ===//

        JButton diceLogoutButton = new JButton("Logout");
        diceLogoutButton.setBounds(340,25,100,35);
        dicePanel.add(diceLogoutButton);
        diceLogoutButton.addActionListener(e5 -> {

            DiceSixArrayList.clear();
            DiceTwelveArrayList.clear();
            diceFrame.setVisible(false);
            loginFrame.setVisible(true);
            loginMessage.setText("");
            passwordTextField.setText("");
        });
        //=== Logout^ ===//
    }

    public static void StartRoulette() {
        JPanel roulettePanel = new JPanel();
        JFrame rouletteFrame = new JFrame("Roulette");
        PanelsAndFrames.getPanelsAndFrames(roulettePanel, rouletteFrame);
        //=== Dicer Frame+Panel^ ===//

        JButton betOnRed = new JButton("Red");
        betOnRed.setBounds(15,30,100,40);
        roulettePanel.add(betOnRed);
        JTextField betOnRedText = new JTextField(50);
        betOnRedText.setBounds(120,30,150,40);
        roulettePanel.add(betOnRedText);
        betOnRed.addActionListener(e1 -> betOnRedText.setText("Your bet is on Red"));
        //=== Red Button&Text Field^ ===//

        JButton betOnBlack = new JButton("Black");
        betOnBlack.setBounds(15,90,100,40);
        roulettePanel.add(betOnBlack);
        JTextField betOnBlackText = new JTextField(50);
        betOnBlackText.setBounds(120,90,150,40);
        roulettePanel.add(betOnBlackText);
        betOnBlack.addActionListener(e2 -> betOnBlackText.setText("Your bet is on Black"));
        //=== Black Button&Text Field^ ===//

        JButton betOnGreen = new JButton("Green");
        betOnGreen.setBounds(15,150,100,40);
        roulettePanel.add(betOnGreen);
        JTextField betOnGreenText = new JTextField(50);
        betOnGreenText.setBounds(120,150,150,40);
        roulettePanel.add(betOnGreenText);
        betOnGreen.addActionListener(e3 -> betOnGreenText.setText("Your bet is on green"));
        //=== Green Button&Text Field^ ===//

        JButton spinWheel = new JButton("Spin Wheel");
        spinWheel.setBounds(155,300,200,40);
        roulettePanel.add(spinWheel);
        spinWheel.addActionListener(e4 -> {
            String x = Integer.toString((int) Roulette());
            rouletteResult.setText(x);

        });
        //=== spinWheel Button^ ===//

        rouletteResult = new JTextField(20);
        rouletteResult.setBounds(230,250,50,50);
        roulettePanel.add(rouletteResult);
        Font thickFont = new Font("SansSerif", Font.BOLD, 40);
        rouletteResult.setFont(thickFont);
        //=== Roulette Result Text Field^ ===//

        JButton rouletteLogoutButton = new JButton("Logout");
        rouletteLogoutButton.setBounds(350,30,100,35);
        roulettePanel.add(rouletteLogoutButton);
        rouletteLogoutButton.addActionListener(e5 -> {

            rouletteFrame.setVisible(false);
            loginFrame.setVisible(true);
            loginMessage.setText("");
            passwordTextField.setText("");
        });
        //=== Logout^ ===//
    }
}