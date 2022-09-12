package ru.sfu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

/**
 * Класс-конфигурации
 */
@Configuration
@PropertySource("classpath:briefcase.properties")
public class SpringConfig {
    /**
     * Создание bean ручки
     * @return ручка
     */
    @Bean
    public Pen pen() {
        return new Pen();
    }

    /**
     * Создание bean тетради
     * @return тетрадь
     */
    @Bean
    public Notebook notebook() {
        return Notebook.getNotebook();
    }

    /**
     * Создание bean книги
     * @return книга
     */
    @Bean
    public Book book() {
        return new Book();
    }

    /**
     * Создание bean портфеля
     * @return портфель
     */
    @Bean
    public Briefcase briefcase() {
        return new Briefcase(Arrays.asList(notebook(), pen(), book()));
    }
}
