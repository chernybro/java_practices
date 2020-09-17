import java.util.Scanner;

public class SumHarmony {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        float sum = 0;
        float a;
        for (int i = 1; i < n; i++) {
            a = (float)1/i;
            if (i < 11) {
                System.out.println(a);
            }
            sum+=a;
        }
        System.out.println(sum);
    }
}
