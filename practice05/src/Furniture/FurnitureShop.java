package Furniture;

import java.util.ArrayList;
import java.util.List;

public class FurnitureShop {
    private List<Chair> chairs;
    private List<Table> tables;
    private ArrayList<Chair> chairsBasket;
    private ArrayList<Table> tablesBasket;

    public FurnitureShop() {
        chairs = new ArrayList<Chair>();
        tables = new ArrayList<Table>();
        chairsBasket = new ArrayList<Chair>();
        tablesBasket = new ArrayList<Table>();
    }

    public void setCatalog() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                chairs.add(new Chair(1000,"black", 40));
            else {
                chairs.add(new Chair(500,"white", 50));
            }
        }
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                tables.add(new Table(2000,"red", 80));
            else {
                tables.add(new Table(5000,"yellow", 120));
            }
        }
    }

    public void getChairsCatalog() {
        for (int i = 0; i < chairs.size(); i++) {
            System.out.println("#" + i + "  " + chairs.get(i));
        }
    }
    public void getTablesCatalog() {
        for (int i = 0; i < tables.size(); i++) {
            System.out.println("#" + i + "  " + tables.get(i));
        }
    }

    public void deleteChair(int position) {
        chairs.remove(position);
    }

    public void deleteTable(int position) {
        tables.remove(position);
    }

    public void addChairToBasket(int i) {
        chairsBasket.add(chairs.get(i));
    }

    public void addTableToBasket(int i) {
        tablesBasket.add(tables.get(i));
    }

    public void getBasket() {
        int sum = 0;
        if (chairsBasket.size() == 0 && tablesBasket.size() == 0) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Cтулья:");
        for (int i = 0; i < chairsBasket.size(); i++) {
            System.out.println("#" + i + "  " + chairsBasket.get(i));
            sum += chairsBasket.get(i).getPrice();

        }
        int k;
        System.out.println("Столы:");
        for (int i = 0; i < tablesBasket.size(); i++) {
            System.out.println("#" + i + "  " + tablesBasket.get(i));
            sum += tablesBasket.get(i).getPrice();
        }
        System.out.println("\n СТОИМОСТЬ + " + sum);
    }


    public void deleteBasket() {
        chairsBasket.clear();
        tablesBasket.clear();
    }


    public void restoreCatalog() {
        chairs.addAll(chairsBasket);
        tables.addAll(tablesBasket);
    }
}
