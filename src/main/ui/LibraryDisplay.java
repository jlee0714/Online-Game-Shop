package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Display for library button
public class LibraryDisplay {
    private JFrame frame;
    private JPanel panel;
    private JButton viewButton;
    private JButton removeButton;
    private JButton searchButton;
    private JButton changeButton;
    private JButton backButton;

    public LibraryDisplay() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(450, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 1));
        libraryDisplay();
    }

    // EFFECTS: displaying the library
    private void libraryDisplay() {
        viewButton();
        removeButton();
        searchButton();
        changeButton();
        backButton();
    }

    // EFFECTS: go back when backButton is pressed;
    private void backButton() {
        backButton = new JButton("Back");
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    //EFFECTS: add view Button
    private void viewButton() {
        viewButton = new JButton("View Library");
        panel.add(viewButton);
    }

    //EFFECTS: add remove Button
    private void removeButton() {
        removeButton = new JButton("Remove Game");
        panel.add(removeButton);
    }

    //EFFECTS: add search Button
    private void searchButton() {
        searchButton = new JButton("Search Game");
        panel.add(searchButton);
    }

    //EFFECTS: add change button
    private void changeButton() {
        changeButton = new JButton("Change Game Data");
        panel.add(changeButton);
    }

    // EFFECTS: get viewButton
    public JButton getViewButton() {
        return viewButton;
    }

    // EFFECTS: get removeButton
    public JButton getRemoveButton() {
        return removeButton;
    }

    // EFFECTS: get searchButton
    public JButton getSearchButton() {
        return searchButton;
    }

    // EFFECTS: get changeButton
    public JButton getChangeButton() {
        return changeButton;
    }
}
