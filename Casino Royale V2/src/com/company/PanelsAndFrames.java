package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelsAndFrames {

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
}
