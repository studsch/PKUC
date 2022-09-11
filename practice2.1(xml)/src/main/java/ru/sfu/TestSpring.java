package ru.sfu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        Briefcase briefcase = context.getBean("briefcase", Briefcase.class);
        briefcase.showAllItems();

        context.close();
    }
}
