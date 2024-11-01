package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Display when search button is pressed
public class SearchDisplay {
    private JFrame frame;
    private JLabel label;
    private JTextField textField;
    private JButton backButton;
    private JButton doneButton;

    public SearchDisplay() {
        label = new JLabel("Search Game:    ");
        textField = new JTextField(20);
        backButton = new JButton("Back");
        doneButton = new JButton("Done");
        frame = new JFrame();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(0, 2));
        searchDisplay();
        frame.setVisible(true);
    }

    // EFFECTS: add all buttons and action performed
    private void searchDisplay() {
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

    // EFFECTS: get textField
    public JTextField getTextField() {
        return textField;
    }

    // EFFECTS: get doneButton
    public JButton getDoneButton() {
        return doneButton;
    }

    // EFFECTS: get frame
    public JFrame getFrame() {
        return frame;
    }

    // EFFECTS: close the frame
    public void closeFrame() {
        frame.dispose();
    }
}
