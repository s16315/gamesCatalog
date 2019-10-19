package pl.gamescatalog.domain.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.gamescatalog.domain.Game;

import java.util.List;

import static org.junit.Assert.*;

public class GamesServiceTest {
    private static List<Game> dataBase;
    private static GamesService gamesService;

    @Before
    public void setUp() {
        dataBase.add(new Game("Fallout", 18, 0));
        dataBase.add(new Game("Minecraft", 3, 1));
        gamesService = new GamesService(dataBase);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveProperErrorMessageOnCreateGameWithExistingId() {
        try {
            gamesService.create(new Game("Snail Bob", 3, 0));
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Existing Id!", exception.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveProperErrorMessageOnCreateGameWithIncorrectPEGI() {
        try {
            gamesService.create(new Game("Snail Bob", -1,10));
            gamesService.create(new Game("Snail Bob", 19,11));
            gamesService.create(new Game("Snail Bob", 50,12));
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Incorrect PEGI!", exception.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveProperErrorMessageOnDeleteGameWithNotExistingId() {
        try {
            gamesService.create(new Game("Snail Bob", 3, 7000));
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Not existing Id!", exception.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveProperErrorMessageOnUpdateGameWithNotExistingId() {
        try {
            gamesService.update(new Game("Snail Bob", 3, 7000));
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Not existing Id!", exception.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveProperErrorMessageOnReadByIdNotExistingGame() {
        try {
            gamesService.update(new Game("Snail Bob", 3, 7000));
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("There is no game with this ID!", exception.getMessage());
        }
    }

}