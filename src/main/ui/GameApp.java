package ui;

import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;

import static model.DifficultyType.*;


// The format of the method of saveLibrary and loadLibrary are from JsonSerializationDemo
// Game Shop Application
public class GameApp extends JFrame {
    private static final String JSON_STORE = "./data/library.json";
    private GameList games;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private DifficultyType type;

    // EFFECTS: run the Game App
    public GameApp() throws FileNotFoundException {
        games = new GameList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runGameShop();
    }

    // MODIFIES: this
    // EFFECTS: start the program
    private void runGameShop() {
        games = new GameList();
        actionMainDisplay();
    }

    // MODIFIES: this
    // EFFECTS: displaying the main page of the program
    private void actionMainDisplay() {
        MainDisplay display = new MainDisplay();
        JButton uploadButton = display.getUploadButton();
        JButton libraryButton = display.getLibraryButton();
        JButton saveButton = display.getSaveButton();
        JButton loadButton = display.getLoadButton();
        JButton quitButton = display.getQuitButton();

        uploadButton(uploadButton);
        libraryButton(libraryButton);
        saveButton(saveButton);
        loadButton(loadButton);

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuitDisplay();
                display.closeFrame();
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.toString());
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: load the data from file when loadButton is clicked
    private void loadButton(JButton loadButton) {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    games = jsonReader.read();
                    new SuccessDisplay("File has been loaded!");
                    EventLog.getInstance().logEvent(new Event("File has been loaded"));

                } catch (IOException i) {
                    new InvalidDisplay("Fail to load");
                    EventLog.getInstance().logEvent(new Event("Fail to load file"));
                }
            }
        });

    }

    // MODIFIES: this
    // EFFECTS: save the data to file when saveButton is clicked
    private void saveButton(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(games);
                    jsonWriter.close();
                    new SuccessDisplay("Saved Successfully!");
                    EventLog.getInstance().logEvent(new Event("File has been saved"));
                } catch (FileNotFoundException i) {
                    new InvalidDisplay("Unable to write to file");
                    EventLog.getInstance().logEvent(new Event("Fail to save file"));
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: upload a game when uploadButton is clicked
    private void uploadButton(JButton uploadButton) {
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UploadDisplay uploadDisplay = new UploadDisplay();
                actionUploadDisplay(uploadDisplay);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: go to library options when libraryButton is clicked
    private void libraryButton(JButton libraryButton) {
        libraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibraryDisplay libraryDisplay = new LibraryDisplay();
                actionLibraryDisplay(libraryDisplay);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: upload a game
    private void actionUploadDisplay(UploadDisplay u) {
        JButton doneButton = u.getDoneButton();
        JTextField nameText = u.getNameText();
        JTextField desText = u.getDescriptionText();
        JTextField priceText = u.getPriceText();
        JTextField cateText = u.getCategoryText();

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameText.getText();
                    String des = desText.getText();
                    int price = Integer.parseInt(priceText.getText());
                    String cate = cateText.getText();
                    selectedDifficulty(u);
                    addGameInLibrary(name, des, price, cate);
                    new SuccessDisplay("Game has been added successfully!");
                } catch (NumberFormatException i) {
                    new InvalidDisplay("Invalid Information");
                    EventLog.getInstance().logEvent(new Event("Fail to add new game"));
                }
                u.closeFrame();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: add a game to gameList
    private void addGameInLibrary(String n, String des, int p, String cate) {
        Game game = new Game(n, des, p, cate);
        game.setDifficulty(type);
        games.addGame(game);
        EventLog.getInstance().logEvent(new Event("Game has been added: " + game.getName()));
    }

    // MODIFIES: this
    // EFFECTS: set the difficulty of a game the user chooses
    private void selectedDifficulty(UploadDisplay u) {
        JCheckBox option1 = u.getOption1();
        JCheckBox option2 = u.getOption2();
        JCheckBox option3 = u.getOption3();
        JCheckBox option4 = u.getOption4();
        JCheckBox option5 = u.getOption5();

        if (option1.isSelected()) {
            type = EASY;
        } else if (option2.isSelected()) {
            type = MEDIUM;
        } else if (option3.isSelected()) {
            type = HARD;
        } else if (option4.isSelected()) {
            type = EXTREME;
        } else if (option5.isSelected()) {
            type = NIGHTMARE;
        }
    }

    // MODIFIES: this
    // EFFECTS: go to library options and displaying it
    private void actionLibraryDisplay(LibraryDisplay l) {
        JButton viewButton = l.getViewButton();
        JButton removeButton = l.getRemoveButton();
        JButton searchButton = l.getSearchButton();
        JButton changeButton = l.getChangeButton();

        view(viewButton);
        remove(removeButton);
        search(searchButton);
        change(changeButton);
    }

    // MODIFIES: this
    // EFFECTS: view the library
    private void view(JButton b) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewDisplay(games);
                EventLog.getInstance().logEvent(new Event("User viewed library"));
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: remove a game in the library
    private void remove(JButton b) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveDisplay removeDisplay = new RemoveDisplay();
                JButton doneButton = removeDisplay.getDoneButton();
                actionRemoveDisplay(doneButton, removeDisplay);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS remove a game in gameList
    private void actionRemoveDisplay(JButton b, RemoveDisplay r) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField text = r.getTextField();
                String s = text.getText();
                if (games.getNameContain(s)) {
                    games.removeGame(s);
                    new SuccessDisplay("Game has been removed successfully!");
                    EventLog.getInstance().logEvent(new Event("Game has been removed: " + s));
                    r.closeFrame();
                } else {
                    new InvalidDisplay("There is no such game in library");
                    EventLog.getInstance().logEvent(new Event("Fail to remove game"));
                    r.closeFrame();
                }

            }
        });
    }

    // MODIFIES: this
    // EFFECTS: search a game in library and displaying it
    private void search(JButton b) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchDisplay searchDisplay = new SearchDisplay();
                JButton doneButton = searchDisplay.getDoneButton();
                actionSearchDisplay(doneButton, searchDisplay);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: search a game in gameList
    private void actionSearchDisplay(JButton b, SearchDisplay sd) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField text = sd.getTextField();
                String s = text.getText();
                List<Game> searched = games.searchGame(s);
                if (!searched.isEmpty()) {
                    GameList searchedGame = new GameList();
                    for (Game g : searched) {
                        searchedGame.addGame(g);
                    }
                    EventLog.getInstance().logEvent(new Event("User searched game using text: " + s));
                    new ViewDisplay(searchedGame);

                } else {
                    new InvalidDisplay("There is no such game in library");
                    EventLog.getInstance().logEvent(new Event("Fail to search game"));
                    sd.closeFrame();
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: change the info of a game in library and displaying it
    private void change(JButton b) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeDisplay changeDisplay = new ChangeDisplay(games);
                JButton doneButton = changeDisplay.getDoneButton();
                changeDisplay(doneButton, changeDisplay);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: change the info of a game in gameList
    private void changeDisplay(JButton b, ChangeDisplay c) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gameName = c.getGameName();
                Game game = games.gameFind(gameName);
                JTextField nameText = c.getNameText();
                JTextField desText = c.getDescriptionText();
                JTextField priceText = c.getPriceText();
                JTextField cateText = c.getCategoryText();

                try {
                    String name = nameText.getText();
                    String des = desText.getText();
                    int price = Integer.parseInt(priceText.getText());
                    String cate = cateText.getText();
                    changeInfo(game, game.getName(), name, des, price, cate, c);
                    new SuccessDisplay("Game data has been changed successfully!");
                } catch (NumberFormatException i) {
                    new InvalidDisplay("Invalid Information");
                    EventLog.getInstance().logEvent(new Event("Fail to change game info"));
                }
                closeFrameForChange(c);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: close the frame of changeDisplay
    private void closeFrameForChange(ChangeDisplay c) {
        c.closeInfoFrame();
        c.closeFrame();
    }

    // MODIFIES: this
    // EFFECT: change the info of a game
    private void changeInfo(Game g, String pn, String n, String d, int p,
                            String c, ChangeDisplay cd) {
        selectedDifficultyForChange(cd);
        g.setName(n);
        g.setDescription(d);
        g.setPrice(p);
        g.setCategory(c);
        g.setDifficulty(type);
        EventLog.getInstance().logEvent(new Event("Game Info has been changed: " + pn));

    }

    // MODIFIES: this
    // EFFECTS: change the difficulty of a game the user want
    private void selectedDifficultyForChange(ChangeDisplay u) {
        JCheckBox option1 = u.getOption1();
        JCheckBox option2 = u.getOption2();
        JCheckBox option3 = u.getOption3();
        JCheckBox option4 = u.getOption4();
        JCheckBox option5 = u.getOption5();

        if (option1.isSelected()) {
            type = EASY;
        } else if (option2.isSelected()) {
            type = MEDIUM;
        } else if (option3.isSelected()) {
            type = HARD;
        } else if (option4.isSelected()) {
            type = EXTREME;
        } else if (option5.isSelected()) {
            type = NIGHTMARE;
        }
    }
}
