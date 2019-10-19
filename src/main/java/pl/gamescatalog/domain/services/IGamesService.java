package pl.gamescatalog.domain.services;
import pl.gamescatalog.domain.Game;
import java.util.ArrayList;
import java.util.List;

public interface IGamesService <Game> {
    public int create(Game game);
    public void readAll();
    public void readById(int id);
    public void update(Game game);
    public void delete(Game game);
}
