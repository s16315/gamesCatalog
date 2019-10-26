package pl.gamescatalog.domain;

public abstract class Entity {
    private long id;

    public long getId() {
        return id;
    }
    void setId(long id) {
        this.id = id;
    }
}
