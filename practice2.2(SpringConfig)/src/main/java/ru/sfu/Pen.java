package ru.sfu;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Класс Ручка
 */
public class Pen implements Item {
    private String inkColor;

    /**
     * init-метод
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("Pen is ready to use");
    }

    /**
     * destroy-метод
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("The pen has run out of ink");
    }

    /**
     * Установить значение полю inkColor
     * @param inkColor - цвет чернил
     */
    @Value("${itemPen.inkColor}")
    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    /**
     * Информация о тетради
     * @return строка с информацией о тетради
     */
    @Override
    public String getItemInfo() {
        return inkColor + " pen";
    }
}
