package za.co.entelect.invest.easy.dojo.messaging.config;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;

@Configuration
public class JmsConfig {

    //This is not required when using SpringBoot (just add properties to applications.properties)
    //Store these in a separate config file/app
    String URL = "tcp://localhost:61616";
    String USERNAME = "admin";
    String PASSWORD = "admin";

    @Bean
    public ActiveMQConnectionFactory connectionFactory() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(URL);
        connectionFactory.setUser(USERNAME);
        connectionFactory.setPassword(PASSWORD);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() throws JMSException {
        return new JmsTemplate(connectionFactory());
//        template.setDefaultDestination(); //this is the default destination that will be used if none is specified in the method
    }

    //TODO: 1. Create the Listener Container Factory

    //TODO: 2. Create the Listener Container using the factory and set the queue

}
