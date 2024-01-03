package com.events.console;

import javax.swing.*;
import java.awt.*;

public class Display {
    static JLabel label=new JLabel();
    static JFrame frame=new JFrame("Mouse Event Tracker");
    static {
        frame.setSize(700,300);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        label.setBounds(20,100,500,50);
        frame.add(label);
        frame.setVisible(true);
    }
    public static void display(String message){
        label.setText(message);
    }
}
