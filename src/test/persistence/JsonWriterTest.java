package persistence;

import model.Game;
import model.GameList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static model.DifficultyType.EASY;
import static model.DifficultyType.HARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// The format of this test is from JsonSerializationDemo
public class JsonWriterTest extends JsonTest{

    private Game game1;
    private Game game2;

    @BeforeEach
    void runBefore() {
        game1 = new Game("overwatch", "fun", 30, "fps");
        game2 = new Game("fifa", "sport", 15, "sport");
        game1.setDifficulty(HARD);
        game2.setDifficulty((EASY));
    }

    @Test
    void testWriterInvalidFile() {
        try {
            GameList games = new GameList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyGameList() {
        try {
            GameList games = new GameList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyGameList.json");
            writer.open();
            writer.write(games);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyGameList.json");
            games = reader.read();
            assertEquals(0, games.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralGameList() {
        try {
            GameList games = new GameList();
            games.addGame(game1);
            games.addGame(game2);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGameList.json");
            writer.open();
            writer.write(games);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGameList.json");
            games = reader.read();
            assertEquals(2, games.getSize());
            List<Game> gameList = games.getLibrary();
            checkGame("overwatch", "fun", 30, "fps", HARD, gameList.get(0));
            checkGame("fifa", "sport", 15, "sport", EASY, gameList.get(1));


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
