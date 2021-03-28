package za.co.entelect.invest.easy.dojo.messaging.config;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import za.co.entelect.invest.easy.dojo.messaging.listener.InvestEasyChangeNotificationListener;

@Configuration
public class ActiveMQConfig {

    //Please note: This is not required when using SpringBoot; we will explicitly define the beans here to demo how it should be done when using a traditional Spring application
    //We will only define the jmsTemplate moving forward as we need to add some of our own properties to it.

    //Store these in a seperate config file/app
    String URL = "tcp://localhost:61616";
    String USERNAME = "admin";
    String PASSWORD = "admin";

    //This will be an activeMQ connectionFactory since our message broker is ActiveMQ
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(URL, USERNAME, PASSWORD);
    }

    @Bean
    public JmsTemplate changeNotificationJmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }

    //TODO 1. Create the SimpleMessageListenerContainer bean
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setMessageListener(new InvestEasyChangeNotificationListener());
        container.setDestinationName("Q.za.co.investeasy.change.notification");

        return container;
    }

}
