package model;

public class Shark extends Predator {
    public String getName() {
        return this.name == null ? "model.Shark" : this.name;
    }
}
