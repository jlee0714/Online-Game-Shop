package persistence;

import model.DifficultyType;
import model.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

// The format of this test is from JsonSerializationDemo
public class JsonTest {
    protected void checkGame(String name, String des, int price, String category, DifficultyType diff,
                               Game g) {
        assertEquals(name, g.getName());
        assertEquals(des, g.getDescription());
        assertEquals(price, g.getPrice());
        assertEquals(category, g.getCategory());
        assertEquals(diff, g.getDifficulty());
    }
}

