package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// display a frame when invalid information is provided
public class InvalidDisplay extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JButton okayButton;
    private ImageIcon image;
    private JLabel imageLabel;

    public InvalidDisplay(String text) {
        image = new ImageIcon("data/invalid-image.png");
        imageLabel = new JLabel(image);
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        frame.setLayout(new GridLayout(0, 1));
        JLabel invalidLabel = new JLabel(text);
        panel.add(imageLabel);
        panel.add(invalidLabel);
        okayButton();
        frame.setVisible(true);
    }

    // EFFECTS: dispose the frame when okayButton is pressed
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
