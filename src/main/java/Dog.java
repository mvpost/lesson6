public class Dog extends Pet{
    public String getName() {
        return this.name == null ? "Dog" : this.name;
    }
}
