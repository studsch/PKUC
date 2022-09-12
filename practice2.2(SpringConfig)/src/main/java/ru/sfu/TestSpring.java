package ru.sfu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SpringConfig.class);

        Briefcase briefcase = context.getBean("briefcase", Briefcase.class);
        briefcase.showAllItems();

        context.close();
    }
}
