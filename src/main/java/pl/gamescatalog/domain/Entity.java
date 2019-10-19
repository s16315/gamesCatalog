package pl.gamescatalog.domain;

public abstract class Entity {
    private double id;

    public double getId() {
        return id;
    }
    void setId(double id) {
        this.id = id;
    }
}
