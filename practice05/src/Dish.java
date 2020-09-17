public abstract class Dish {
    protected String material;
    protected String color;

    protected Dish(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public abstract void toWashDish();

    public abstract void toThrowDish();
}
