package ru.sfu;

import java.util.List;

/**
 * Класс Портфель
 */
public class Briefcase {
    private List<Item> items;

    /**
     * Конструктор
     * @param items - список с предметами
     */
    public Briefcase(List<Item> items) {
        this.items = items;
    }

    /**
     * Установить значение полю item
     * @param item - предмет
     */
    public void setItem(Item item) {
        items.add(item);
    }

    /**
     * Вывод всех предметов в портфеле
     */
    public void showAllItems() {
        if (items.isEmpty())
            System.out.println("Briefcase empty");
        else {
            StringBuilder allItems = new StringBuilder("Briefcase contains:");
            for (Item item: items) {
                allItems.append("\n").append(item.getItemInfo());
            }
            System.out.println(allItems);
        }
    }
}
