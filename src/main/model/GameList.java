package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.List;
import java.util.ArrayList;


public class GameList implements Writable {
    private final List<Game> library;
    private Game game;

    public GameList() {
        library = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add a game in game list
    public void addGame(Game g) {
        library.add(g);
    }

    // EFFECTS: get the library in game list
    public List<Game> getLibrary() {
        return library;
    }

    // EFFECTS: get the size of game list
    public int getSize() {
        return library.size();
    }

    // EFFECTS: get true if game list has the game
    public boolean getContain(Game g) {
        return library.contains(g);
    }

    // EFFECTS: get true if a game has the name
    public boolean getNameContain(String nm) {
        boolean result = false;
        for (Game g : library) {
            String n = g.getName();

            if (nm.equals(n)) {
                result = true;
                break;
            }
        }
        return result;
    }

    // REQUIRES: the given string must be one of the name of the games
    // MODIFIES: this
    // EFFECTS: remove a game from the game list
    public void removeGame(String s) {
        int count = 0;
        while (count < library.size()) {
            Game game = library.get(count);
            if (s.equals(game.getName())) {
                library.remove(count);
            }
            count += 1;
        }
    }

    // REQUIRES: the given string must be one of the name of the games
    // EFFECTS: return the game that has the given name
    public Game gameFind(String nm) {
        for (Game g : library) {
            if (nm.equals(g.getName())) {
                game = g;
            }
        }
        return game;
    }

    // MODIFIES: this
    // EFFECTS: return the games that contain related name to the given word
    public List<Game> searchGame(String s) {
        List<Game> searched = new ArrayList<>();
        for (Game g : library) {
            s = s.toLowerCase();
            String nm = g.getName();
            nm = nm.toLowerCase();
            if (nm.contains(s)) {
                searched.add(g);
            }
        }

        return searched;
    }

    // MODIFIES: this
    // EFFECTS: return the games in order of date
    public List<Game> byDate() {
        List<Game> games = new ArrayList<>();
        int count = (library.size() - 1);

        while (count >= 0) {
            Game g = library.get(count);
            games.add(g);
            count -= 1;
        }

        return games;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Games", gamesToJson());
        return json;
    }

    // EFFECTS: returns games in this library as a JSON array
    private JSONArray gamesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Game t : library) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
