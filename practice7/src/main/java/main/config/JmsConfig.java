package main.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import java.util.Queue;

@Configuration
@EnableJms
public class JmsConfig {
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        String BROKER_URL = "tcp://localhost:61616";
        connectionFactory.setBrokerURL(BROKER_URL);
        String BROKER_USERNAME = "admin";
        connectionFactory.setUserName(BROKER_USERNAME);
        String BROKER_PASSWORD = "admin";
        connectionFactory.setPassword(BROKER_PASSWORD);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName("sample.queue");
        return template;
    }

    @Bean
    public Queue queue() {
        return (Queue) new ActiveMQQueue("sample.queue");
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        return new MappingJackson2MessageConverter();
    }
}
