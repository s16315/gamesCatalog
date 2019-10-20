package pl.gamescatalog.domain.services;
import java.util.List;

public interface IGamesService <Game> {
    public int create(Game game);
    public List<pl.gamescatalog.domain.Game> readAll();
    public Game readById(int id);
    public void update(Game game);
    public void delete(Game game);
}
