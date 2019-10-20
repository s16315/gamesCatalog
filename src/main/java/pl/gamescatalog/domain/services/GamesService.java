package pl.gamescatalog.domain.services;
import pl.gamescatalog.domain.Game;

import java.util.List;

public class GamesService implements IGamesService<Game> {
    private List<Game> gamesList;

    GamesService(List<Game> gamesList) {
        this.gamesList = gamesList;
    }

    public int create(Game game) {
        return 0;
    }

    public List<Game> readAll() {
        return this.gamesList;
    }

    public Game readById(int id) {
        //Game game = gamesList.stream().filter(g -> g.getId() == id).findFirst();
        return game;
    }

    public void update(Game game) {

    }

    public void delete(Game game) {

    }

}
