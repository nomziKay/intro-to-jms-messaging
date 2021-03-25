package za.co.entelect.invest.easy.dojo.messaging.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Map;

@Component
public class MessagePublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger("MessagePublisher.class");

    private final JmsTemplate jmsTemplate;

    public MessagePublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendTextMessage(final String destination, final String message) {
        LOGGER.info("================Sending simple text message=========================");
        LOGGER.info("Destination: " + destination);
        LOGGER.info("Message: " + message);

        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
        LOGGER.info("================Done sending simple text message====================");
    }

    public void sendConvertedTextMessage(final String destination, final Map<String, String> message) {
        LOGGER.info("================Sending converted text message=========================");
        LOGGER.info("Destination: " + destination);
        LOGGER.info("Message: " + message);

        //TODO: 1. Use JmsTemplate to convert and send the message
   

        LOGGER.info("================Done sending simple text message====================");

    }

}
