package ui;

import model.Game;
import model.GameList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Display of change button option
public class ChangeDisplay {
    private JFrame frame;
    private JFrame infoFrame;
    private JButton backButton1;
    private JButton backButton2;
    private JButton doneButton;
    private List<Game> games;
    private JButton gameNameButton;
    private JTextField nameText;
    private JTextField descriptionText;
    private JTextField priceText;
    private JTextField categoryText;
    private JLabel infoLabel;
    private JLabel emptyLabel;
    private JLabel nameLabel;
    private JLabel desLabel;
    private JLabel priceLabel;
    private JLabel cateLabel;
    private JLabel difficultyLabel;
    private JCheckBox option1;
    private JCheckBox option2;
    private JCheckBox option3;
    private JCheckBox option4;
    private JCheckBox option5;
    private String gameName;

    public ChangeDisplay(GameList gms) {
        games = gms.getLibrary();
        backButton1 = new JButton("Back");
        backButton2 = new JButton("Back");
        doneButton = new JButton("Done");
        frame = new JFrame();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(0, 1));
        gameDisplay();
        frame.setVisible(true);
        infoLabel = new JLabel("Change Information");
        emptyLabel = new JLabel("    ");
        nameLabel = new JLabel("Game Name:    ");
        nameText = new JTextField(20);
        desLabel = new JLabel("Description:    ");
        descriptionText = new JTextField(20);
        priceLabel = new JLabel("Price:    ");
        priceText = new JTextField(20);
        cateLabel = new JLabel("Category:    ");
        categoryText = new JTextField(20);
    }

    // EFFECTS: make a frame and add all buttons to display
    private void changeDisplay() {
        infoFrame = new JFrame();
        infoFrame.setSize(400, 220);
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoFrame.setVisible(true);
        infoFrame.setLayout(new GridLayout(0, 2));
        infoFrame.add(infoLabel);
        infoFrame.add(emptyLabel);
        infoFrame.add(nameLabel);
        infoFrame.add(nameText);
        infoFrame.add(desLabel);
        infoFrame.add(descriptionText);
        infoFrame.add(priceLabel);
        infoFrame.add(priceText);
        infoFrame.add(cateLabel);
        infoFrame.add(categoryText);
        addDifficultly();
        infoFrame.add(backButton2);
        infoFrame.add(doneButton);
    }

    // EFFECTS: add checkbox to choose difficulty
    private void addDifficultly() {
        difficultyLabel = new JLabel("Difficulty:");
        JLabel selection = new JLabel("select one below");
        JLabel emptyLabel = new JLabel("     ");
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
        infoFrame.add(difficultyLabel);
        infoFrame.add(selection);
        infoFrame.add(option1);
        infoFrame.add(option2);
        infoFrame.add(option3);
        infoFrame.add(option4);
        infoFrame.add(option5);
        infoFrame.add(emptyLabel);
    }

    // EFFECTS: provide the games in library to choose which game's
    // information the user want to change data
    private void gameDisplay() {
        if (games.size() > 0) {
            for (Game g : games) {
                String name = g.getName();
                gameNameButton = new JButton(name);
                frame.add(gameNameButton);
                gameNameButton(g);
            }
        }

        frame.add(backButton1);
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
        });

    }

    private void gameNameButton(Game g) {
        gameNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameName = gameNameButton.getText();
                informationDisplay();
                changeDisplay();
            }
        });
    }

    // EFFECTS: go back when press backButton
    private void informationDisplay() {
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoFrame.dispose();
            }
        });
    }

    // EFFECTS: close the infoFrame
    public void closeInfoFrame() {
        infoFrame.dispose();
    }

    // EFFECTS: get game name
    public String getGameName() {
        return gameName;
    }

    // EFFECTS: close the frame
    public void closeFrame() {
        frame.dispose();
    }

    // EFFECTS: get doneButton
    public JButton getDoneButton() {
        return doneButton;
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
}
