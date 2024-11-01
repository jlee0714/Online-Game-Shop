package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void runBefore() {
        game = new Game("Overwatch", "It is fun fps game.", 30, "FPS");
    }

    @Test
    void constructorTest() {
        assertEquals("Overwatch", game.getName());
        assertEquals("It is fun fps game.", game.getDescription());
        assertEquals(30, game.getPrice());
        assertEquals("FPS", game.getCategory());
        assertEquals(null, game.getDifficulty());
    }

    @Test
    void setTest() {
        game.setName("fifa");
        game.setDescription("It's soccer game");
        game.setPrice(50);
        game.setCategory("Sport");
        game.setDifficulty(DifficultyType.MEDIUM);
        assertEquals("fifa", game.getName());
        assertEquals("It's soccer game", game.getDescription());
        assertEquals(50, game.getPrice());
        assertEquals("Sport", game.getCategory());
        assertEquals(DifficultyType.MEDIUM, game.getDifficulty());
    }

    @Test
    void isName() {
        assertTrue(game.isName("Overwatch"));
        assertFalse(game.isName("fifa"));
    }
}