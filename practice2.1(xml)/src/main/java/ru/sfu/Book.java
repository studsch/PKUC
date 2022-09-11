package ru.sfu;

/**
 * Класс Книга
 */
public class Book implements Item {
    private String name;
    private String author;

    /**
     * Установить значение полю name
     * @param name - название книги
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Установить значение полю author
     * @param author - автор книги
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Информация о книги
     * @return строка с информацией о книге
     */
    @Override
    public String getItemInfo() {
        return name + " by: " + author;
    }
}
