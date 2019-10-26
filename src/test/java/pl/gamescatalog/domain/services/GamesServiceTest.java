package pl.gamescatalog.domain.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.gamescatalog.domain.Game;

import java.util.*;

import static java.lang.System.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class GamesServiceTest {
    private static ArrayList<Game> dataBase = new ArrayList<Game>();
    private static GamesService gamesService;
    private Game game1 = new Game("Fallout", 18, 1);
    private Game game2 = new Game("Minecraft", 3, 2);
    private Game game3 = new Game("Snail Bob 1", 3, 3);
    private Game game4 = new Game("Snail Bob 2", 3, 4);
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp() {

        dataBase.add(this.game1);
        dataBase.add(this.game2);
        gamesService = new GamesService(dataBase);

    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveProperErrorMessageOnCreateGameWithExistingId() {
        try {
            gamesService.create(this.game1);
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Existing Id!", exception.getMessage());
        }
    }

    @Test
    public void createdGameShouldBeEqualToSource() throws Exception {
        gamesService.create(this.game3);
        assertEquals(gamesService.readById(this.game3.getId()).getName(), this.game3.getName());
        assertEquals(gamesService.readById(this.game3.getId()).getPegi(), this.game3.getPegi());
    }

    @Test
    public void gameGetByIdGameShouldBeEqualToSource() throws Exception {
        assertEquals(gamesService.readById(this.game1.getId()).getName(), this.game1.getName());
        assertEquals(gamesService.readById(this.game1.getId()).getPegi(), this.game1.getPegi());
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
        gamesService.create(this.game1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveProperErrorMessageOnDeleteGameWithNotExistingIdOLD() {
        try {
            gamesService.create(this.game1);
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
            assertThat(exception.getMessage(), containsString("Existing Id!"));

            //System.out.println(exception.getMessage());
            //String t1 = new String(exception.getMessage());
            //String t2 = new String("Existing Id!");
            //assertEquals(new IllegalArgumentException("Existing Id!").getMessage(), exception.getMessage());
            //assertSame(t1, t2);
            //System.out.println(t1.equals(t2));
            //assertEquals( t1, t2);
            //assertEquals( "Existing Id!", new String(exception.getMessage()));
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