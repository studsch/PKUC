package ru.sfu;

/**
 * Класс Тетрадь
 */
public class Notebook implements Item {
    private int pages;

    /**
     * Установить значение полю pages
     * @param pages - количество страниц
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Информация о тетради
     * @return строка с информацией о тетради
     */
    @Override
    public String getItemInfo() {
        return "Notebook " + pages + " sheets";
    }
}
