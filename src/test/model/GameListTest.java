package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameListTest {
    private Game game1;
    private Game game2;
    private Game game3;
    private Game game4;
    private GameList games;

    @BeforeEach
    void runBefore() {
        game1 = new Game("Overwatch", "It is fun fps game.", 30, "FPS");
        game2 = new Game("Overwee", "It is fun sport game.", 27, "SPORT");
        game3 = new Game("FIFA24", "It is fun soccer game.", 40, "SPORT");
        game4 = new Game("Overwatch", "It is fun.", 60, "FPS");
        games = new GameList();
    }

    @Test
    void addOneGameTest() {
        games.addGame(game1);
        assertEquals(1, games.getSize());
        assertTrue(games.getContain(game1));
        assertFalse(games.getContain(game2));
    }

    @Test
    void addMultipleGameTest() {
        games.addGame(game1);
        games.addGame(game2);
        assertEquals(2, games.getSize());
        assertTrue(games.getContain(game1));
        assertTrue(games.getContain(game2));
        assertFalse(games.getContain(game3));
    }

    @Test
    void getLibraryTest() {
        games.addGame(game1);
        games.addGame(game2);
        List<Game> listedGame;
        listedGame = games.getLibrary();
        assertEquals(2, listedGame.size());
        assertTrue(listedGame.contains(game1));
        assertTrue(listedGame.contains(game2));
        assertFalse(listedGame.contains(game3));

    }

    @Test
    void removeTest() {
        games.addGame(game1);
        games.addGame(game2);
        games.removeGame("Overwatch");
        assertEquals(1, games.getSize());
        assertFalse(games.getContain(game1));
        assertTrue(games.getContain(game2));
    }

    @Test
    void removeMultipleGameTest() {
        games.addGame(game1);
        games.addGame(game2);
        games.addGame(game3);
        games.addGame(game4);
        games.removeGame("Overwatch");
        assertEquals(2, games.getSize());
        assertFalse(games.getContain(game1));
        assertTrue(games.getContain(game2));
        assertTrue(games.getContain(game3));
        assertFalse(games.getContain(game4));

    }

    @Test
    void getNameContainTest() {
        games.addGame(game1);
        games.addGame(game2);
        assertFalse(games.getNameContain("fifa"));
        assertTrue(games.getNameContain("Overwatch"));
    }

    @Test
    void gameFindTest() {
        games.addGame(game1);
        games.addGame(game2);
        Game gm;
        gm = games.gameFind("Overwatch");
        assertEquals("Overwatch", gm.getName());
    }

    @Test
    void emptySearchGameTest() {
        String s = "p";
        GameList games = new GameList();
        games.addGame(game1);
        games.addGame(game2);
        games.addGame(game3);
        List<Game> test;
        test = games.searchGame(s);
        assertEquals(0, test.size());

    }

    @Test
    void searchGameTest() {
        String s = "Overwatch";
        GameList games = new GameList();
        games.addGame(game1);
        games.addGame(game2);
        games.addGame(game3);
        List<Game> test;
        test = games.searchGame(s);
        assertEquals(1, test.size());
        assertTrue(test.contains(game1));
        assertFalse(test.contains(game2));
    }

    @Test
    void searchCapitalLetterTest() {
        String s = "OVERWATCH";
        GameList games = new GameList();
        games.addGame(game1);
        games.addGame(game2);
        games.addGame(game3);
        List<Game> test;
        test = games.searchGame(s);
        assertEquals(1, test.size());
        assertTrue(test.contains(game1));
        assertFalse(test.contains(game2));
    }

    @Test
    void searchLetterInGameTest() {
        String s = "Over";
        GameList games = new GameList();
        games.addGame(game1);
        games.addGame(game2);
        games.addGame(game3);
        List<Game> test;
        test = games.searchGame(s);
        assertEquals(2, test.size());
        assertTrue(test.contains(game1));
        assertTrue(test.contains(game2));
        assertFalse(test.contains(game3));
    }

    @Test
    void byDateTest() {
        GameList games = new GameList();
        games.addGame(game1);
        games.addGame(game2);
        games.addGame(game3);
        List<Game> test;
        test = games.byDate();
        assertEquals(3, test.size());
        assertEquals(game3, test.get(0));
        assertEquals(game2, test.get(1));
        assertEquals(game1, test.get(2));
    }
}