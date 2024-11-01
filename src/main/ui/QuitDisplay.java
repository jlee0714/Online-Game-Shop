package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Display quitButton when it is clicked
public class QuitDisplay {
    private JFrame frame;
    private JPanel panel;
    private JButton okayButton;
    private ImageIcon image;
    private JLabel imageLabel;

    public QuitDisplay() {
        image = new ImageIcon("data/thumbs-up.png");
        Image originalImage = image.getImage();
        Image resizeImage = originalImage.getScaledInstance(100, 100,
                Image.SCALE_SMOOTH);
        image = new ImageIcon(resizeImage);
        imageLabel = new JLabel(image);
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        frame.setLayout(new GridLayout(0, 1));
        JLabel invalidLabel = new JLabel("Goodbye!!!");
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
