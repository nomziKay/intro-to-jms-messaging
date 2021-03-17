package za.co.entelect.invest.easy.dojo.messaging.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagePublisher.class);

    private final JmsTemplate jmsTemplate;

    public MessagePublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendTextMessage(final String destination, final String message) {
        LOGGER.info("================Sending simple text message=========================");
        LOGGER.info("Destination: " + destination);
        LOGGER.info("Message: " + message);
        //TODO: 3. Send a simple text message using the jmsTemplate
        LOGGER.info("================Done sending simple text message====================");
    }

}
