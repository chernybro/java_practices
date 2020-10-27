import com.sun.security.jgss.GSSUtil;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class MapLoader {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String > phonesMap = new TreeMap<String, String>(); //<phone, name>

        String buffer;

        for(;;) {
            buffer = scanner.nextLine();
            if (buffer.equals("LIST")) {
                for (Map.Entry<String,String> entry : phonesMap.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
                }
            }
            else if (isNameCorrect(buffer)) {
                if (phonesMap.containsValue(buffer)) {
                    for (Map.Entry<String, String> entry : phonesMap.entrySet()) {
                        if (entry.getValue().equals(buffer)) {
                            System.out.println(entry.getKey() + "------" + entry.getValue());
                        }
                    }
                } else {
                    System.out.println("Enter number phone");
                    String numberPhone = scanner.nextLine();
                    String name = buffer;
                    if (isNumberPhoneCorrect(numberPhone)) {
                        numberPhone = changeNumberToNiceForm(numberPhone);
                        phonesMap.put(numberPhone, name);
                        System.out.println("added\n");
                    }
                }
            } else if (isNumberPhoneCorrect(buffer)) {
                String numberPhone = buffer;
                numberPhone = changeNumberToNiceForm(numberPhone);
                if (phonesMap.containsKey(numberPhone)) {
                    for (Map.Entry<String, String> entry : phonesMap.entrySet()) {
                        if (entry.getKey().equals(numberPhone)) {
                            System.out.println(entry.getKey() + "------" + entry.getValue());
                        }
                    }
                } else {
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    if (isNameCorrect(name)) {
                        phonesMap.put(numberPhone, name);
                        System.out.println("added\n");
                    }
                }
            }
        }
    }

    private static String changeNumberToNiceForm(String phone) {
        phone = phone.replaceAll("[^0-9]", "");
        StringBuffer result = new StringBuffer();
        if (phone.charAt(0) == '7' && phone.length() == 11) {
            result.append(phone);
            result.insert(0, "+");
            result.insert(2, " (");
            result.insert(7, ") ");
            result.insert(12, "-");
            result.insert(15, "-");

        } else if (phone.charAt(0) == '8' && phone.length() == 11) {
            result.append(phone);
            result.delete(0,1);
            result.insert(0, "+7");
            result.insert(2, " (");
            result.insert(7, ") ");
            result.insert(12, "-");
            result.insert(15, "-");

        }
        else if (phone.length() == 10) {
            result.append(phone);
            result.insert(0, "+7");
            result.insert(2, " (");
            result.insert(7, ") ");
            result.insert(12, "-");
            result.insert(15, "-");

        }
        else {
            System.out.println("Неверный ввод");
        }
        return result.toString();
    }

    static boolean isNameCorrect(String name) {
        return Pattern.matches("([A-ZА-Я]([a-zа-я]+\\s*)){1,3}", name);
        //Name
        //Name Surname
        //Name Surname (Middle name s)
    }

    static boolean isNumberPhoneCorrect(String phone) {
        phone = phone.replaceAll("[^0-9]", "");
        return (phone.length() <= 11 && phone.length() >= 10)&&
                ((phone.charAt(0) == '7' && phone.length() == 11) ||
                        (phone.charAt(0) == '8' && phone.length() == 11) ||
                        (phone.length() == 10));
    }
}
