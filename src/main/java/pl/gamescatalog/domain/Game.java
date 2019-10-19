package pl.gamescatalog.domain;

public class Game extends Entity {
    private String name;
    private Number pegi;
    private String type;

    public Game(String name, Number pegi, String type, int id) {
        this.name = name;
        this.pegi = pegi;
        this.type = type;
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPegi() {
        return pegi;
    }

    public void setPegi(Number pegi) {
        this.pegi = pegi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
