public class Loader {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.setRadius(5);
        System.out.println("radius = " + circle.getRadius());
        System.out.println("S = " + circle.getSqr());
        System.out.println("L = " + circle.getLength());


        /////////////////////////////////////////////


        Human human = new Human("белый", "эктоморф");

        System.out.println("цвет кожи - " + human.getColor());

        System.out.println(human);

        System.out.println();


        Human.Head head = new Human.Head("круглая", false, "black", "blue");

        System.out.println(head);

    }
}
