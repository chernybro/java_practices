package Furniture;

import java.util.Scanner;

public class FurnitureLoader {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FurnitureShop furnitureShop = new FurnitureShop();
        furnitureShop.setCatalog();
        int choice;
        int number;
        while (true) {
            System.out.println("В нашем ассортименте есть: \n   1. Стулья \n   2. Столы. \n   3. Перейти в корзину \nВведите номер желаемой группы товаров");
            choice = in.nextInt();
            if (choice == 1) {
                furnitureShop.getChairsCatalog();
                System.out.println("Выберите номер стула для покупки");
                number = in.nextInt();
                furnitureShop.addChairToBasket(number);
                furnitureShop.deleteChair(number);
            }
            else if (choice == 2) {
                furnitureShop.getTablesCatalog();
                System.out.println("Выберите номер стола для покупки");
                number = in.nextInt();
                furnitureShop.addTableToBasket(number);
                furnitureShop.deleteTable(number);
            }
            else if (choice == 3) {
                furnitureShop.getBasket();

                System.out.println("Желаете приобрести выбранные товары? 1. Да 2. Нет");

                number = in.nextInt();
                if (number == 1) {
                    furnitureShop.deleteBasket();
                }
                else if (number == 2) {
                    furnitureShop.restoreCatalog();
                }
            }
        }
    }
}
