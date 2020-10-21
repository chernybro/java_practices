import javax.print.attribute.standard.PresentationDirection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 88005553535
        // +7-800-555-35-35

        String phone;

        StringBuffer result = new StringBuffer();

        Scanner scanner = new Scanner(System.in);

        phone = scanner.nextLine();


            phone = phone.replaceAll("[^0-9]", "");

            if (!(phone.length() > 11 || phone.length() < 10)) {
                if (phone.charAt(0) == '7' && phone.length() == 11) {
                    result.append(phone);
                    result.insert(0, "+");
                    result.insert(2, " (");
                    result.insert(7, ") ");
                    result.insert(12, "-");
                    result.insert(15, "-");
                    System.out.println(result);
                    result.delete(0, result.length());

                } else if (phone.charAt(0) == '8' && phone.length() == 11) {
                    result.append(phone);
                    result.delete(0,1);
                    result.insert(0, "+7");
                    result.insert(2, " (");
                    result.insert(7, ") ");
                    result.insert(12, "-");
                    result.insert(15, "-");
                    System.out.println(result);
                    result.delete(0, result.length());
                }
                else if (phone.length() == 10) {
                    result.append(phone);
                    result.insert(0, "+7");
                    result.insert(2, " (");
                    result.insert(7, ") ");
                    result.insert(12, "-");
                    result.insert(15, "-");
                    System.out.println(result);
                    result.delete(0, result.length());

                }
                else {
                    System.out.println("Неверный ввод");
                }
            } else {
                System.out.println("Неверный");
            }
        }



}
