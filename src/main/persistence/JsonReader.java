package persistence;

import model.DifficultyType;
import model.Game;
import model.GameList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// The format of this class is from JsonSerializationDemo
// Represents a reader that reads GameList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads library from file and returns it;
    // throws IOException if an error occurs reading data from file
    public GameList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses library from JSON object and returns it
    private GameList parseWorkRoom(JSONObject jsonObject) {
        GameList games = new GameList();
        addThingies(games, jsonObject);
        return games;
    }

    // MODIFIES: games
    // EFFECTS: parses library from JSON object and adds them to GameList
    private void addThingies(GameList games, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Games");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addThingy(games, nextThingy);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses game from JSON object and adds it to GameList
    private void addThingy(GameList games, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String des = jsonObject.getString("Description");
        int price = jsonObject.getInt("Price");
        String category = jsonObject.getString("Category");
        DifficultyType diff = DifficultyType.valueOf(jsonObject.getString("Difficulty"));

        Game g = new Game(name, des, price, category);
        g.setDifficulty(diff);
        games.addGame(g);
    }
}
