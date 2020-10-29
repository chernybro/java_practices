import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String[] chars = new String[]{"А", "В","Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х", };


        ArrayList<String> al = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        TreeSet<String> ts = new TreeSet<>();

        for (int i = 1; i < 200; i++) {
            for (String x : chars) {
                for (String y : chars) {
                    for (String z : chars) {
                        for ( int j = 1; j < 8; j++) {
                            String format = String.format("%s%03d%s%s%03d", x, j * 111, y, z, i);
                            System.out.println(format);
                            al.add(format);
                            hs.add(format);
                            ts.add(format);
                        }
                    }
                }
            }
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите искомый номер. Для выхода введите пробел");

        while(true) {
            String s = scanner.nextLine();
            if (s.equals(" ")) {
                break;
            } else {
                long start = System.nanoTime();
                boolean b = al.contains(s);
                long time = System.nanoTime() - start;
                System.out.println("Поиск перебором. Номер " + (b ? "найден" : "не найден") + ". Время поиска - " +  time);


                Collections.sort(al);
                start = System.nanoTime();
                Collections.binarySearch(al, s);
                time = System.nanoTime() - start;
                System.out.println("Бинарный поиск. Номер " + (Collections.binarySearch(al, s) >= 0 ? "найден" : "не найден") + ". Время поиска - " +  time);

                start = System.nanoTime();
                b = hs.contains(s);
                time = System.nanoTime() - start;
                System.out.println("Поиск в HashSet. Номер " + (b ? "найден" : "не найден") + ". Время поиска - " +  time);

                start = System.nanoTime();
                b = ts.contains(s);
                time = System.nanoTime() - start;
                System.out.println("Поиск в HashSet. Номер " + (b ? "найден" : "не найден") + ". Время поиска - " +  time);
            }
        }

    }
}
