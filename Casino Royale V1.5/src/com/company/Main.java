package com.company; /**/ import javax.swing.*; /**/ import java.awt.*;
import java.util.ArrayList; /**/ import java.util.Collections;

public class Main {

    public static ArrayList<String> DiceSixArrayList = new ArrayList<>();
    public static ArrayList<String> DiceTwelveArrayList = new ArrayList<>();
    private static JTextField usernameTextField; /**/ private static JTextField diceSixResult;
    private static JTextField diceTwelveResult; /**/ private static JTextField savedDiceTextField6;
    private static JTextField savedDiceTextField12; /**/ private static JPasswordField passwordTextField;
    private static JLabel loginMessage; /**/ private static JFrame loginFrame;

    static double D6() {
        return (int)(Math.random()*((6-1))+ (double) 1);
    }
    static double D12() {
        return (int)(Math.random()*((12-1))+ (double) 1);
    }

    public static void main(String[] args) {

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

            if(userName.equals("test") && passWord.equals("test")) {

                loginFrame.setVisible(false);

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

                rouletteButton.addActionListener(e2 -> {

                });

                diceButton.addActionListener(e3 -> {

                    choiceFrame.setVisible(false);
                    JPanel dicePanel = new JPanel();
                    JFrame diceFrame = new JFrame("Dice");
                    diceFrame.setVisible(true);
                    diceFrame.setSize(500,400);
                    diceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    diceFrame.setLocationRelativeTo(null);
                    diceFrame.add(dicePanel);
                    dicePanel.setLayout(null);
                    dicePanel.setBackground(Color.getHSBColor(0,20,202));
                    //=== Dicer Frame+Panel^ ===//

                    JButton rollDiceSix = new JButton("Roll 1-6");
                    rollDiceSix.setBounds(15,30,100,40);
                    diceSixResult = new JTextField(20);
                    diceSixResult.setBounds(155,30,100,40);
                    dicePanel.add(diceSixResult);
                    dicePanel.add(rollDiceSix);
                    rollDiceSix.addActionListener(e4 -> {

                        String x = Double.toString(D6());
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
                    rollDiceTwelve.addActionListener(e5 -> {

                        String x = Double.toString(D12());
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
                    printSavedButton.addActionListener(e6 -> {

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
                    deleteRollsButton.addActionListener(e7 -> {

                        DiceSixArrayList.clear();
                        DiceTwelveArrayList.clear();
                        savedDiceTextField6.setText("(D6) :");
                        savedDiceTextField12.setText("(D12):");
                    });
                    //=== Delete rolls^ ===//

                    JButton casinoRedButton = new JButton("CasinoRed");
                    casinoRedButton.setBounds(185,285,125,35);
                    dicePanel.add(casinoRedButton);
                    casinoRedButton.addActionListener(e8 -> dicePanel.setBackground( new Color(114, 6, 6) ));
                    //=== CasinoRed^ ===//

                    JButton smoothBrightButton = new JButton("SmoothBright");
                    smoothBrightButton.setBounds(330,285,125,35);
                    dicePanel.add(smoothBrightButton);
                    smoothBrightButton.addActionListener(e9 -> dicePanel.setBackground(Color.getHSBColor(0,20,202)));
                    //=== SmoothBright^ ===//

                    JButton logoutButton = new JButton("Logout");
                    logoutButton.setBounds(340,25,100,35);
                    dicePanel.add(logoutButton);
                    logoutButton.addActionListener(e10 -> {

                        DiceSixArrayList.clear();
                        DiceTwelveArrayList.clear();
                        diceFrame.setVisible(false);
                        loginFrame.setVisible(true);
                        loginMessage.setText("");
                        passwordTextField.setText("");
                    });
                    //=== Logout^ ===//
                });
            }
            else {
                loginMessage.setText("Wrong username or password, try again");
            }
        });
    }
}