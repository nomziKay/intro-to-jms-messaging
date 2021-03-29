package za.co.entelect.invest.easy.dojo.messaging.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQConfig {

    //Please note: This is not required when using SpringBoot; we will explicitly define the beans here to demo how it should be done when using a traditional Spring application
    //We will only define the jmsTemplate moving forward as we need to add some of our own properties to it.

    //Store these in a seperate config file/app
    String URL = "tcp://localhost:61616";
    String USERNAME = "admin";
    String PASSWORD = "admin";

    //TODO: 1. Create the connectionFactory
    //This will be an activeMQ connectionFactory since our message broker is ActiveMQ

    //TODO: 2. Create a jmsTemplate bean named changeNotificationJmsTemplate


}
