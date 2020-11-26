import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Loader {
    public static void main(String[] args) {
        final String name = "data\\movementList.csv";

        String line = "";
        String cvsSplitBy = ",";

        HashMap<String, Integer> incomes = new HashMap<>();
        HashMap<String, Integer> expenses = new HashMap<>();



        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String describe = "";
            while ((line = br.readLine()) != null) {
                
                String[] column = line.split(cvsSplitBy);


                if (column[5].contains("\\"))
                    describe = column[5].substring(column[5].lastIndexOf("\\") + 1, column[5].indexOf("          "));
                else if (column[5].contains("/"))
                    describe = column[5].substring(column[5].lastIndexOf("/") + 1, column[5].indexOf("          "));

                column[6] = column[6].replaceAll("\\D", "");
                column[7] = column[7].replaceAll("\\D", "");


                System.out.println("Приход = " + column[6] + " , расход = " + column[7] + "\nОписание - " + describe + "\n");

                if (column[6].matches("\\d+") && column[7].matches("\\d+")) {
                    int income = Integer.parseInt(column[6]);
                    int expense = Integer.parseInt(column[7]);
                    if (income > 0) {
                        int sum = 0;
                        if (incomes.containsKey(describe)) {
                            sum += incomes.get(describe);
                        }
                        incomes.put(describe, sum + income);
                    } else {
                        int sum = 0;
                        if (expenses.containsKey(describe)) {
                            sum += expenses.get(describe);
                        }
                        expenses.put(describe, sum + expense);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Доходы");
        for(Map.Entry<String, Integer> entry: incomes.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        System.out.println();
        System.out.println();
        System.out.println("Расходы");
        for(Map.Entry<String, Integer> entry: expenses.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}
