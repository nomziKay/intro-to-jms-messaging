package za.co.entelect.invest.easy.dojo.messaging.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class InvestEasyChangeNotificationListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvestEasyChangeNotificationListener.class);

    @Override
    public void onMessage(Message message) {
        //TODO: 2. Implement this method by checking if it is a TextMessage then log the message received from the queue
        if (!(message instanceof TextMessage)) {
            LOGGER.error("Message cannot be processed as oit is not a type of TextMessage");
        }

        try {
            String textMessage = ((TextMessage) message).getText();
            LOGGER.info("Received the following changes='{}'", textMessage);
        } catch (JMSException e) {
            LOGGER.error("Unable to read TextMessage", e);
        }

    }
}
