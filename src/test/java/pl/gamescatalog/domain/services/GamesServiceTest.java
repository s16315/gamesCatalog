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

    @Before
    public void setUp() {

        dataBase.add(this.game1);
        dataBase.add(this.game2);
        gamesService = new GamesService(dataBase);

    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldBeIllegalArgumentExceptionOnCreateGameWithExistingId() {
        gamesService.create(this.game1);
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
    public void shouldBeIllegalArgumentExceptionOnCreateGameWithIncorrectPEGI() {
        gamesService.create(new Game("Snail Bob", -1,10));
        gamesService.create(new Game("Snail Bob", 19,11));
        gamesService.create(new Game("Snail Bob", 50,12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveProperErrorMessageOnDeleteGameWithNotExistingId() {
        gamesService.create(this.game1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldBeIllegalArgumentExceptionOnOnDeleteGameWithNotExistingIdOLD() {
        gamesService.create(this.game1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeIllegalArgumentExceptionOnOnUpdateGameWithNotExistingId() {
            gamesService.update(new Game("Snail Bob", 3, 7000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeIllegalArgumentExceptionOnReadByIdNotExistingGame() {
        gamesService.update(new Game("Snail Bob", 3, 7000));
    }

}