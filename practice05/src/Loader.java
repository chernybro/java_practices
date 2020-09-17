public class Loader {
    public static void main(String[] args) {
        Plate plate = new Plate("wood", "black");

        plate.condition = "bad"; // bad/good
        plate.toThrowDish();

        plate.setDiameter(20);
        System.out.println("diameter is " + plate.getDiameter());

        System.out.println("\n");

        Cutlery cutlery = new Cutlery("metal", "grey");

        cutlery.purity = "dirty"; // dirty/clean
        cutlery.toWashDish();

        cutlery.setType("spoon");
        System.out.println("type - " + cutlery.getType());

        System.out.println(cutlery);

        /////////////////////////////dog

        Pug pug = new Pug("white", 30);

        pug.setDogWantToWalk(false);
        System.out.println();
        pug.toWalkWithDog();
        System.out.println();

        Poodle poodle = new Poodle("blue", false);

        poodle.toWalkWithDog();

    }
}
