package com.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {

    private int counter = 0;

    public CounterApp() {
        setTitle("CounterApp window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 250, 120);
        setLayout(new GridLayout(2,3));

        Font font = new Font("Arial", Font.BOLD, 30);

        JButton incrementButton = new JButton(">");
        add(incrementButton);

        JLabel counterView = new JLabel(String.valueOf(counter));
        counterView.setHorizontalAlignment(SwingConstants.CENTER);
        counterView.setFont(font);
        add(counterView);

        JButton decrementButton = new JButton("<");
        add(decrementButton);

        JButton incrementTenButton = new JButton("10 >");
        add(incrementTenButton);

        JButton resetButton = new JButton("Reset");
        add(resetButton);

        JButton decrementTenButton = new JButton("< 10");
        add(decrementTenButton);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == incrementButton) {
                    counter++;
                } else if (e.getSource() == decrementButton) {
                    counter--;
                } else if (e.getSource() == incrementTenButton) {
                    counter = counter + 10;
                } else if (e.getSource() == decrementTenButton) {
                    counter = counter - 10;
                } else if (e.getSource() == resetButton) {
                    counter = 0;
                }
                refreshCounterView(counterView);
            }
        };

        decrementButton.addActionListener(actionListener);
        incrementButton.addActionListener(actionListener);
        decrementTenButton.addActionListener(actionListener);
        incrementTenButton.addActionListener(actionListener);
        resetButton.addActionListener(actionListener);

        setVisible(true);
    }

    private void refreshCounterView(JLabel counterView) {
        counterView.setText(String.valueOf(counter));
    }

    public static void main(String[] args) {
        new CounterApp();
    }

}
