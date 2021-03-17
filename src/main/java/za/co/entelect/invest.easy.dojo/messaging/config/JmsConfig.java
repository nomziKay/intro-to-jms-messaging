package za.co.entelect.invest.easy.dojo.messaging.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

    //This is not required when using SpringBoot
    //Store these in a seperate config file/app
    String URL = "tcp://localhost:61616";
    String USERNAME = "admin";
    String PASSWORD = "admin";

    //TODO: 1. Create the connectionFactory
    //This will be an activeMQ connectionFactory since our message broker is ActiveMQ


    //TODO: 2. Create the jmsTemplate bean


}
