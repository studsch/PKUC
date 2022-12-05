package main.JMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String string) {
        jmsTemplate.convertAndSend(string);
        System.out.println("Message sent to the Queue");
    }
}
