package ui;

import model.Game;
import model.GameList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Display when view button is clicked
public class ViewDisplay {
    private JFrame frame;
    private JFrame gameFrame;
    private GameList gameList;
    private List<Game> games;
    private JLabel name;
    private JLabel des;
    private JLabel price;
    private JLabel cate;
    private JLabel diff;
    private JButton backButton;
    private JButton gameNameButton;

    public ViewDisplay(GameList gameList) {
        this.gameList = gameList;
        games = gameList.getLibrary();
        backButton = new JButton("Back");
        frame = new JFrame();
        frame.setSize(120, 100);
        frame.setLayout(new GridLayout(0, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gameDisplay();
        frame.setVisible(true);
    }

    // EFFECTS: provide games to choose which game's info the user
    // want to view
    private void gameDisplay() {
        for (Game g : games) {
            String name = g.getName();
            gameNameButton = new JButton(name);
            frame.add(gameNameButton);
            gameButton(g);
        }
        backButton(backButton, frame);
    }

    // EFFECTS: provide the info of the game
    private void gameInfoDisplay(Game g) {
        gameFrame = new JFrame();
        gameFrame.setSize(180, 150);
        gameFrame.setLayout(new GridLayout(0, 1));
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        name = new JLabel("Name:    " + g.getName());
        gameFrame.add(name);
        des = new JLabel("Description:    " + g.getDescription());
        gameFrame.add(des);
        price = new JLabel("Price:    $" + g.getPrice());
        gameFrame.add(price);
        cate = new JLabel("Category:    " + g.getCategory());
        gameFrame.add(cate);
        diff = new JLabel("Difficulty:    " + g.getDifficulty());
        gameFrame.add(diff);
        backButton(backButton, gameFrame);
        gameFrame.setVisible(true);
    }

    // EFFECTS: add action to the game button
    private void gameButton(Game g) {
        gameNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameInfoDisplay(g);
            }
        });
    }

    // EFFECTS: add backButton and go back when it is clicked
    private void backButton(JButton backButton, JFrame f) {
        f.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }
}
