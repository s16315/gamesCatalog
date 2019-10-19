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

    public void readAll() {

    }

    public void readById(int id) {

    }

    public void update(Game game) {

    }

    public void delete(Game game) {

    }

}
