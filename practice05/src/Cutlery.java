public class Cutlery extends Dish {
    private String type;
    public String condition;
    public String purity;

    public Cutlery(String material, String color) {
        super(material, color);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void toWashDish() {
        if (purity == "dirty") {
            System.out.println("Моем посуду...");
        }
        else {
            System.out.println("Посуда уже чистая!");
        }
    }

    @Override
    public void toThrowDish() {
        if (condition == "bad") {
            System.out.println("Выкидываем посуду...");
        }
        else {
            System.out.println("Посуда слишком хороша чтобы её выбрасывать!");
        }

    }

    @Override
    public String toString() {
        return "Cutlery{" +
                "type='" + type + '\'' +
                ", condition='" + condition + '\'' +
                ", purity='" + purity + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
