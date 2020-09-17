
public class Loader {
    public static void main(String[] args) {
        Calendar mCalendar = new Calendar();
        mCalendar.setDay(3);
        mCalendar.rotate();
        System.out.println(mCalendar);

        Calendar cal2 = new Calendar();

        cal2.setDay(4);
        cal2.month = "Сентябрь";
        cal2.year = 2012;

        System.out.println();
        System.out.println(cal2);

        // Мяч
        Ball ball = new Ball();
        ball.setColor("red");
        ball.setDiameter(15);
        ball.setType("football ball");
        System.out.println(ball);

        System.out.println();
        // книга
        Book book = new Book();
        book.setAuthor("Я");
        book.setCountOfPages(1);
        book.setPublisher("Просвещение");
        book.setTitle("Programming on Java");
        book.setYear(2020);
        System.out.println(book);

        //
        System.out.println();
        System.out.println();

        Dog[] dogs = new Dog[3];

        for (int i = 0; i < 3; i++) {
            dogs[i] = new Dog();
        }

        dogs[0].setAge(1);
        dogs[0].setBreed("Овчарка");
        dogs[0].setColor("Коричневый");
        System.out.println(dogs[0].toHumanAges() + " Человеческих лет");
        System.out.println(dogs[0]);

        dogs[1].setAge(3);
        dogs[1].setBreed("Мопс");
        dogs[1].setColor("белый");
        System.out.println(dogs[1].toHumanAges() + " Human ages");

        dogs[2].setAge(4);
        dogs[2].setBreed("Долматинец");
        dogs[2].setColor("Черно-белый");

        Dog dog = new Dog("Лайка", 5, "Бежевый");

        System.out.println();
        System.out.println();

        System.out.println(dog);
    }
}
