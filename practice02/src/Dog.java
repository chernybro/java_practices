public class Dog {
    private String breed;
    private int age;
    private String color;

    public String toString() {
        return "Порода " + breed + "\nСколько лет:" + age + "\nЦвет " + color;
    }

    public Dog(){}
    public Dog(String breed, int age, String color) {
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    public int toHumanAges() {
        return this.age*7;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
