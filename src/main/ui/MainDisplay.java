package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Display main page
public class MainDisplay extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JButton uploadButton;
    private JButton libraryButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton quitButton;

    public MainDisplay() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 1));
        mainDisplay();
    }

    //EFFECTS: displaying main page
    private void mainDisplay() {
        uploadButton();
        libraryButton();
        saveButton();
        loadButton();
        quitButton();
    }

    //EFFECTS: add upload button
    private void uploadButton() {
        uploadButton = new JButton("Upload");
        panel.add(uploadButton);
    }

    //EFFECTS: add library button
    private void libraryButton() {
        libraryButton = new JButton("Library");
        panel.add(libraryButton);
    }

    //EFFECTS: add save button
    private void saveButton() {
        saveButton = new JButton("Save");
        panel.add(saveButton);
    }

    //EFFECTS: add load button
    private void loadButton() {
        loadButton = new JButton("Load");
        panel.add(loadButton);
    }

    //EFFECTS: add quit button
    private void quitButton() {
        quitButton = new JButton("Quit");
        panel.add(quitButton);
        frame.setVisible(true);
    }

    // EFFECTS: get uploadButton
    public JButton getUploadButton() {
        return uploadButton;
    }

    // EFFECTS: get libraryButton
    public JButton getLibraryButton() {
        return libraryButton;
    }

    // EFFECTS: get saveButton
    public JButton getSaveButton() {
        return saveButton;
    }

    // EFFECTS: get loadButton
    public JButton getLoadButton() {
        return loadButton;
    }

    // EFFECTS: get quitButton
    public JButton getQuitButton() {
        return quitButton;
    }

    // EFFECTS: close the frame
    public void closeFrame() {
        frame.dispose();
    }
}
