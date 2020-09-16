package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Main implements ActionListener {

    ArrayList<String> SaveD6 = new ArrayList<>();
    ArrayList<String> SaveD12 = new ArrayList<>();

    private static JTextField UT;
    private static JTextField UT10;
    private static JTextField UT20;
    private static JTextField UT30;
    private static JTextField UT40;
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
        frame = new JFrame("Dice Generator Login");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0,20,202));
        //=== Skapar Login Frame och sätter storleken^ ==========//

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

            JPanel panel10 = new JPanel();
            JFrame frame10 = new JFrame("Dice Generator");
            frame10.setVisible(true);
            frame10.setSize(500,400);
            frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame10.add(panel10);
            panel10.setLayout(null);
            panel10.setBackground(Color.getHSBColor(0,20,202));
            //=== Skapar Dice frame^ ===================//

            JButton button10 = new JButton("Roll 1-6");
            button10.setBounds(20,60,100,40);
            UT10 = new JTextField(20);
            UT10.setBounds(160,60,100,40);
            panel10.add(UT10);
            panel10.add(button10);
            button10.addActionListener(e1 -> {
               String y = Double.toString(D6());
               UT10.setText(y);

                SaveD6.add(y);
            });
            //=== Skapar Dice 1-6 knapp/Text^ ===========//

            JButton button20 = new JButton("Roll 1-12");
            button20.setBounds(20,130,100,40);
            UT20 = new JTextField(20);
            UT20.setBounds(160,130,100,40);
            panel10.add(UT20);
            panel10.add(button20);
            button20.addActionListener(e12 -> {
                String y10 = Double.toString(D12());
                UT20.setText(y10);

                SaveD12.add(y10);
            });
            //=== Skapar Dice 1-12 knapp/Text^ ===========//

            JButton button30 = new JButton("Print saved rolls");
            button30.setBounds(20,250,145,40);
            UT30 = new JTextField(100);
            UT30.setBounds(180,225,250,40);
            panel10.add(UT30);
            UT40 = new JTextField(100);
            UT40.setBounds(180,270,250,40);
            panel10.add(UT40);
            panel10.add(button30);
            button30.addActionListener(e13 -> {

                Collections.sort(SaveD6);
                Collections.sort(SaveD12);
                String y20 = SaveD6.toString();
                String y30 = SaveD12.toString();
                UT30.setText("D6 Rolls: " + y20);
                UT40.setText("D12 Rolls: " + y30);
            });
            //== Skapar Print Saved Rolls knapp/Text^ ====//
        }
        else {
            S.setText("Wrong username or password, try again");
        }
    }
}