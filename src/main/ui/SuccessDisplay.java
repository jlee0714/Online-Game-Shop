package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Display a frame when something goes well
public class SuccessDisplay {
    private JFrame frame;
    private JPanel panel;
    private JButton okayButton;

    public SuccessDisplay(String success) {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        frame.setLayout(new GridLayout(0, 1));
        JLabel successLabel = new JLabel(success);
        panel.add(successLabel);
        okayButton();
        frame.setVisible(true);
    }

    //EFFECTS: dispose the frame when click okayButton
    private void okayButton() {
        okayButton = new JButton("Okay");
        panel.add(okayButton);
        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
