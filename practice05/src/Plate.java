public class Plate extends Dish {
    private int diameter;
    public String condition;
    public String purity;

    public Plate(String material, String color) {
        super(material, color);
    }


    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
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
        return "Plate{" +
                "diameter='" + diameter + '\'' +
                ", condition='" + condition + '\'' +
                ", purity='" + purity + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
