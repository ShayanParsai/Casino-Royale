package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelsAndFrames {

    private final Font mediumThickFont = new Font("SansSerif", Font.BOLD, 17);

    public void getPanelsAndFrames(JPanel panel,JFrame frame,int width,int height) {
        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0,20,202));
    }

    public void getGameLogTextField(JTextField textField,JPanel panel,int userCredits,int x,int y) {
        textField.setBounds(x,y,400,50);
        panel.add(textField);
        textField.setFont(mediumThickFont);
        textField.setEditable(false);
        textField.setText("You have " + userCredits + " credits");
    }

    public void getCurrentWagerTextField(JTextField textField, JPanel panel,int x,int y) {
        textField.setBounds(x,y,50,40);
        panel.add(textField);
        textField.setFont(mediumThickFont);
        textField.setEditable(false);
    }

    public void getButton(JButton lobby, JPanel panel, int x, int y, int width, int height) {
        lobby.setBounds(x,y,width,height);
        panel.add(lobby);
    }

    public void getLabel(JLabel label, JPanel panel, int x, int y, int width, int height) {
        label.setBounds(x,y,width,height);
        panel.add(label);
    }

    public void getTextField(JTextField textField, JPanel panel, int x, int y, int width, int height) {
        textField.setBounds(x,y,width,height);
        panel.add(textField);
    }
}
