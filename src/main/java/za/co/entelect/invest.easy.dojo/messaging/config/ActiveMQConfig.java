package za.co.entelect.invest.easy.dojo.messaging.config;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import za.co.entelect.invest.easy.dojo.messaging.listener.InvestEasyChangeNotificationListener;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.JMSException;

@Configuration
public class ActiveMQConfig {

    //Please note: This is not required when using SpringBoot; we will explicitly define the beans here to demo how it should be done when using a traditional Spring application

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

    @Bean
    public MappingJackson2MessageConverter jacksonMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    //We explicitly define connection factory so we can set the PubSubDomain property
    @Bean(name = "easyInvestJmsTemplate")
    public JmsTemplate jmsTemplate() throws JMSException {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
        jmsTemplate.setMessageConverter(jacksonMessageConverter());
        return jmsTemplate;
    }

    @Bean
    public DefaultJmsListenerContainerFactory stockMarketContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("1-1"); //number of consumers to create. Starts with minimum then scales up as load increases
        factory.setPubSubDomain(true);
        factory.setMessageConverter(jacksonMessageConverter());
        return factory;
    }

}
