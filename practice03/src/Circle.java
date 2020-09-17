public class Circle {
    private int radius;


    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getLength() {
        return 2*radius* Math.PI;
    }

    public double getSqr() {
        return Math.PI * radius * radius;
    }
}
