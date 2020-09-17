public class Poodle extends Dog {
    private boolean isDogWantToWalk;


    public Poodle(String color, boolean isDogWantToWalk) {
        super(color);
        this.isDogWantToWalk = isDogWantToWalk;
    }

    @Override
    public void toWalkWithDog() {
        if (isDogWantToWalk == true) {
            System.out.println("Идем гулять с собакой");
        }
        else {
            System.out.println("ПУДЕЛЬ гулять не хочет");
        }
    }
}
