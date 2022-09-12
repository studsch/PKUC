package ru.sfu;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Класс Тетрадь
 */
public class Notebook implements Item {
    private int pages;

    /**
     * init-метод
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("Notebook is empty");
    }

    /**
     * destroy-метод
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("Notebook is over");
    }

    // Конструктор приватный, чтобы не создавать объект с помощью new
    private Notebook() {}

    /**
     * Фабричный метод
     * @return объект тетради
     */
    public static Notebook getNotebook() {
        return new Notebook();
    }

    /**
     * Установить значение полю pages
     * @param pages - количество страниц
     */
    @Value("${itemNotebook.pages}")
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
