package model;

public class Wolf extends Predator {
    public String getName() {
        return this.name == null ? "model.Wolf" : this.name;
    }
}
