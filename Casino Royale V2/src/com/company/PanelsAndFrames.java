package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelsAndFrames {

    private final Font mediumThickFont = new Font("SansSerif", Font.BOLD, 17);
    public final Font thickFont = new Font("SansSerif", Font.BOLD, 40);

    public void getMediumPanelsAndFrames(JPanel panel, JFrame frame) {
        frame.setVisible(true);
        frame.setSize(525,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0,20,202));
    }

    public void getSmallPanelsAndFrames(JPanel panel, JFrame frame) {
        frame.setVisible(true);
        frame.setSize(350,175);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0,20,202));
    }

    public void getGameLogTextField(JTextField textField, JPanel panel, int userCredits) {
        textField.setBounds(15,380,400,50);
        panel.add(textField);
        textField.setFont(mediumThickFont);
        textField.setEditable(false);
        textField.setText("You have " + userCredits + " credits");
    }

    public void getCurrentWagerTextField(JTextField textField, JPanel panel) {
        textField.setBounds(335,465,50,40);
        panel.add(textField);
        textField.setFont(mediumThickFont);
        textField.setEditable(false);
    }

    public void getRaiseAndLowerWagerButtons(JButton low, JButton high, JPanel panel) {
        low.setBounds(15,465,150,40);
        high.setBounds(175,465,150,40);
        panel.add(low);
        panel.add(high);
    }

    public void getLogOutButton(JButton logout, JPanel panel) {
        logout.setBounds(115,85,90,35);
        panel.add(logout);
    }

    public void getExitToLobbyButton(JButton lobby, JPanel panel) {
        lobby.setBounds(400,465,90,40);
        panel.add(lobby);
    }
}