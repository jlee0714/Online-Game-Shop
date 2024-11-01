package persistence;

import model.DifficultyType;
import model.Game;
import model.GameList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// The format of this test is from JsonSerializationDemo
public class JsonReaderTest extends JsonTest{
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            GameList games = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyGameList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGameList.json");
        try {
            GameList games = reader.read();
            assertEquals(0, games.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralGameList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGameList.json");
        try {
            GameList games = reader.read();
            List<Game> gameList = games.getLibrary();
            assertEquals(2, gameList.size());
            checkGame("overwatch", "fps", 30, "fps",
                    DifficultyType.HARD, gameList.get(0));
            checkGame("fifa", "sport", 15, "sport",
                    DifficultyType.EASY, gameList.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
