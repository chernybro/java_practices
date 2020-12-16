import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        int[] arrSum = new int[10];

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            arrSum[i] = in.nextInt();
        }
        int sum = 0;
        int i = 0;
        while (i < arrSum.length) {
            sum += arrSum[i++];
        }
        System.out.println(sum);

    }
}
