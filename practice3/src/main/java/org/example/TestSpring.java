package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class TestSpring {

    static final int LOWER_CHOICE = 0;
    static final int UPPER_CHOICE_MENU = 5;
    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SpringConfig.class);

        BagDao bagDao = context.getBean("bagDao", BagDao.class);

        int id = 1;

        boolean flag = true;
        int userChoice;
        while (flag) {
            System.out.println(
                    "Нажмите на одну из клавиш:\n"+
                    "0. Добавить новую сумку\n" +
                    "1. Показать все сумки\n" +
                    "2. Изменить параметры сумки (по id)\n" +
                    "3. Удалить сумку (по id)\n" +
                    "4. Поиск\n" +
                    "5. Выход"
            );
            userChoice = getInt();
            while ((userChoice < LOWER_CHOICE) || (userChoice > UPPER_CHOICE_MENU)) {
                System.out.println("Введена неизвестная команда. Попробуйте еще раз");
                userChoice = getInt();
            }
            Menu menu = Menu.values()[userChoice];
            switch (menu) {
                case ADD -> {
                    System.out.println("Введите материал сумки:");
                    String material = scan.nextLine();

                    System.out.println("Введите брэнд сумки:");
                    String brand = scan.nextLine();

                    System.out.println("Введите страну изготовителя сумки:");
                    String country = scan.nextLine();

                    System.out.println("Введите высоту сумки:");
                    int height = getInt();

                    System.out.println("Введите высоту ширину:");
                    int width = getInt();

                    System.out.println("Введите высоту глубину:");
                    int depth = getInt();

                    Bag bag = new Bag(
                            id,
                            material,
                            brand,
                            country,
                            height,
                            width,
                            depth
                    );
                    id++;
                    bagDao.insert(bag);
                }
                case OUTPUT -> {
                    List<Bag> bags = bagDao.findAll();
                    for (Bag bag: bags) {
                        System.out.println(bag);
                    }
                }
                case UPDATE -> {
                    System.out.println("Введите id сумки, которую хотите изменить:");
                    int bag_id = getInt();

                    System.out.println("Введите материал сумки:");
                    String material = scan.nextLine();

                    System.out.println("Введите бренд сумки:");
                    String brand = scan.nextLine();

                    System.out.println("Введите страну изготовителя сумки:");
                    String country = scan.nextLine();

                    System.out.println("Введите высоту сумки:");
                    int height = getInt();

                    System.out.println("Введите высоту ширину:");
                    int width = getInt();

                    System.out.println("Введите высоту глубину:");
                    int depth = getInt();

                    Bag bag = new Bag(
                            id,
                            material,
                            brand,
                            country,
                            height,
                            width,
                            depth
                    );
                    bagDao.update(bag_id, bag);
                }
                case REMOVE -> {
                    System.out.println("Введите id сумки, которую хотите удалить:");
                    int bag_id = getInt();
                    bagDao.delete(bag_id);
                }
                case SEARCH -> {
                    System.out.println("Введите максимальную высоту сумки:");
                    int maxHigh = getInt();
                    Bag bag = bagDao.show(maxHigh);
                    if (bag.equals(null)) {
                        System.out.println("Нет сумок меньше этой высоты");
                    } else {
                        System.out.println("Одна из сумок, которая вам подходит: " + bag);
                    }
                }
                case SHUT_DOWN -> flag = false;
            }
        }
        context.close();
    }

    /**
     * Функция для получения числа от пользователя
     * @return число
     */
    static int getInt() {
        int number;

        while (true) {
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                scan.nextLine();

                if (number < 0) {
                    System.out.println("Введите положительное число!");
                } else break;
            } else {
                scan.nextLine();
                System.out.println("Введите число!");
            }
        }

        return number;
    }
}

/**
 * Меню
 */
enum Menu {
    ADD,
    OUTPUT,
    UPDATE,
    REMOVE,
    SEARCH,
    SHUT_DOWN
}
