import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = fact(in.nextInt());
        System.out.println(k);
    }
    static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n*fact(n-1);
    }
}
