package ui;

import model.Game;
import model.GameList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Display when remove Button is pressed
public class RemoveDisplay {
    private JFrame frame;
    private JLabel label;
    private JTextField textField;
    private JButton backButton;
    private JButton doneButton;

    public RemoveDisplay() {
        doneButton = new JButton("Done");
        backButton = new JButton("Back");
        textField = new JTextField(20);
        label = new JLabel("Game Name:    ");
        frame = new JFrame();
        frame.setSize(300, 100);
        frame.setLayout(new GridLayout(0, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeDisplay();
        frame.setVisible(true);
    }

    //EFFECTS: add all buttons and action performed
    private void removeDisplay() {
        frame.add(label);
        frame.add(textField);
        frame.add(backButton);
        frame.add(doneButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    // EFFECTS: get doneButton
    public JButton getDoneButton() {
        return doneButton;
    }

    // EFFECTS: get textField
    public JTextField getTextField() {
        return textField;
    }

    // EFFECTS: close the frame
    public void closeFrame() {
        frame.dispose();
    }

}
