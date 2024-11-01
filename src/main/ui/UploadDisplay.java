package ui;

import model.DifficultyType;

import javax.swing.*;
import java.awt.*;


// Display when Upload Button is clicked
public class UploadDisplay extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JButton doneButton;
    private DifficultyType type;
    private JCheckBox option1;
    private JCheckBox option2;
    private JCheckBox option3;
    private JCheckBox option4;
    private JCheckBox option5;
    private JTextField nameText;
    private JTextField descriptionText;
    private JTextField priceText;
    private JTextField categoryText;


    public UploadDisplay() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 2));
        addGameDisplay();
    }

    // EFFECTS: add all button for displaying
    private void addGameDisplay() {
        JLabel nameLabel = new JLabel("Game Name:");
        nameText = new JTextField(20);
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionText = new JTextField(20);
        JLabel priceLabel = new JLabel("Price:");
        priceText = new JTextField(20);
        JLabel categoryLabel = new JLabel("Category:");
        categoryText = new JTextField(20);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(descriptionLabel);
        panel.add(descriptionText);
        panel.add(priceLabel);
        panel.add(priceText);
        panel.add(categoryLabel);
        panel.add(categoryText);
        addDifficultly();
        doneButton();
        frame.setVisible((true));
    }

    // EFFECTS: add checkbox to choose difficulty
    private void addDifficultly() {
        JLabel difficultyLabel = new JLabel("Difficulty:");
        JLabel selection = new JLabel("select one below");
        option1 = new JCheckBox("Easy");
        option2 = new JCheckBox("Medium");
        option3 = new JCheckBox("Hard");
        option4 = new JCheckBox("Extreme");
        option5 = new JCheckBox("Nightmare");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);
        buttonGroup.add(option5);
        panel.add(difficultyLabel);
        panel.add(selection);
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);
        panel.add(option5);
    }

    // EFFECTS: add doneButton
    private void doneButton() {
        doneButton = new JButton("Done");
        panel.add(doneButton);
    }

    // EFFECTS: get the frame
    public JFrame getFrame() {
        return frame;
    }

    // EFFECTS: close the frame
    public void closeFrame() {
        frame.dispose();
    }

    // EFFECTS: get option1
    public JCheckBox getOption1() {
        return option1;
    }

    // EFFECTS: get option2
    public JCheckBox getOption2() {
        return option2;
    }

    // EFFECTS: get option3
    public JCheckBox getOption3() {
        return option3;
    }

    // EFFECTS: get option4
    public JCheckBox getOption4() {
        return option4;
    }

    // EFFECTS: get option5
    public JCheckBox getOption5() {
        return option5;
    }

    // EFFECTS: get nameText
    public JTextField getNameText() {
        return nameText;
    }

    // EFFECTS: get descriptionText
    public JTextField getDescriptionText() {
        return descriptionText;
    }

    // EFFECTS: get priceText
    public JTextField getPriceText() {
        return priceText;
    }

    // EFFECTS: get categoryText
    public JTextField getCategoryText() {
        return categoryText;
    }

    // EFFECTS: get doneButton
    public JButton getDoneButton() {
        return doneButton;
    }
}
