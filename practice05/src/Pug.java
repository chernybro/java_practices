public class Pug extends Dog{
    private int height;
    private boolean isDogWantToWalk;

    public void setDogWantToWalk(boolean dogWantToWalk) {

        isDogWantToWalk = dogWantToWalk;
    }

    public Pug(String color, int height) {
        super(color);
        this.height = height;
    }

    @Override
    public void toWalkWithDog() {
        if (isDogWantToWalk == true) {
            System.out.println("Идем гулять с собакой");
        }
        else {
            System.out.println("МОПС гулять не хочет");
        }
    }
}
