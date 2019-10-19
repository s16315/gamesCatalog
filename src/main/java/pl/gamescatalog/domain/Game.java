package pl.gamescatalog.domain;

public class Game extends Entity {
    private String name;
    private Number pegi;
    private Boolean haveDemo;
    private String description;

    public Game(String name, Number pegi, double id) {
        this.name = name;
        this.pegi = pegi;
        this.haveDemo = false;
        this.description = "";
        this.setId(id);
    }

    public Game(String name, Number pegi, Boolean haveDemo, String description, double id) {
        this.name = name;
        this.pegi = pegi;
        this.haveDemo = haveDemo;
        this.description = description;
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

    public Boolean getHaveDemo() {
        return haveDemo;
    }

    public void setHaveDemo(Boolean haveDemo) {
        this.haveDemo = haveDemo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
