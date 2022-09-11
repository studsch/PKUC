package ru.sfu;

/**
 * Класс Ручка
 */
public class Pen implements Item {
    private String inkColor;

    /**
     * Установить значение полю inkColor
     * @param inkColor - цвет чернил
     */
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
