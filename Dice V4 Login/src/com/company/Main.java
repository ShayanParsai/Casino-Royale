package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main implements ActionListener {

    private static JTextField UT;
    private static JPasswordField PT;
    private static JLabel S;
    private static JFrame frame;

    static double D6() {
        return (int)(Math.random()*((6-1))+ (double) 1);
    }
    static double D12() {
        return (int)(Math.random()*((12-1))+ (double) 1);
    }

    public static void main(String[] args) {

        JPanel panel = new JPanel();
        frame = new JFrame("Dice Generator");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0,20,202));
        //=== Skapar JFrame och sätter storleken^ ==============//

        JLabel UL = new JLabel("Username:");
        UL.setBounds (10,20,80,25);
        panel.add(UL);
        UT = new JTextField(20);
        UT.setBounds(100,20,165,25);
        panel.add(UT);
        //==== Username text och frame^ ========================//

        JLabel PL = new JLabel("Password:");
        PL.setBounds (10,50,80,25);
        panel.add(PL);
        PT = new JPasswordField(20);
        PT.setBounds(100,50,165,25);
        panel.add(PT);
        //====== Password text och frame^ =======================//

        JButton button = new JButton("Login");
        button.setBounds(10,80,80,25);
        button.addActionListener(new Main());
        panel.add(button);
        //====== Login knapp^ ===================================//

        S = new JLabel("");
        S.setBounds(100,80,300,25);
        panel.add(S);
        frame.setVisible(true);
        //====== Texten som visas när man clickar login^ =========//
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String ut = UT.getText();
        String pw = PT.getText();

        if(ut.equals("Test") && pw.equals("Test")) {
            S.setText("Login Successful");
            frame.setVisible(false);

            ArrayList<Double> SaveD6 = new ArrayList<>();
                ArrayList<Double> SaveD12 = new ArrayList<>();

                DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

                System.out.println("========================");
                LocalDateTime NOW = LocalDateTime.now();
                System.out.println(DATE.format(NOW));
                System.out.println("========================");

                Scanner Namn = new Scanner(System.in);
                System.out.print("Your name: ");
                String NamN = Namn.next();

                int loop = 1;
                System.out.println("========================");
                System.out.println("Welcome "+NamN+" to the Dicer!");

                while (loop == 1) {

                    System.out.println("========================");
                    System.out.println("[1] Roll dice with 6 figures");
                    System.out.println("[2] Roll dice with 12 figures");
                    System.out.println("[3] Print out all saved rolls");
                    System.out.println("[4] Exit");

                    Scanner Menyval = new Scanner(System.in);
                    System.out.print("Menyval: ");
                    int x = Menyval.nextInt();

                    switch (x) {
                        case 1 -> { // Rullar tärning med 6 sidor, sparar tärnings rull till ArrayList SaveD6
                            System.out.println("========================");
                            Double Roll1 = D6();
                            SaveD6.add(Roll1);
                            System.out.println("You rolled " + Roll1);
                        }
                        case 2 -> { // Rullar tärning med 12 sidor, sparar tärnings rull till ArrayList SaveD12
                            System.out.println("========================");
                            Double Roll2 = D12();
                            SaveD12.add(Roll2);
                            System.out.println("You rolled " + Roll2);
                        }
                        case 3 -> { // Sorterar båda listorna, skriver ut alla sparade resultat i storleks ordning
                            System.out.println("========================");
                            Collections.sort(SaveD6);
                            Collections.sort(SaveD12);
                            System.out.println("All your previous D6 rolls: " + SaveD6);
                            System.out.println("All your previous D12 rolls: " + SaveD12);
                        }
                        case 4 -> { // Exit
                            System.out.println("========================");
                            LocalDateTime NOW1 = LocalDateTime.now();
                            System.out.println(DATE.format(NOW1));
                            System.out.println("========================");
                            System.out.println("Thank you " + NamN + " for using my program");
                            loop++;
                        }
                        default -> { // Om användaren skriver in ett menyval som inte finns
                            System.out.println("========================");
                            System.out.println("You can only choose between 1-4");
                        }
                    }
                }
            }
            else {
            S.setText("Wrong username or password, try again");
            }
        }
    }

