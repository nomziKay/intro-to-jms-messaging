package za.co.entelect.invest.easy.dojo.messaging.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import za.co.entelect.invest.easy.dojo.messaging.service.InvestEasyChangeNotificationService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import static za.co.entelect.invest.easy.dojo.messaging.domain.Constants.CHANGE_NOTIFICATION_QUEUE;

@Service
public class InvestEasyChangeNotificationServiceImpl implements InvestEasyChangeNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvestEasyChangeNotificationServiceImpl.class);

    private final JmsTemplate jmsTemplate;

    public InvestEasyChangeNotificationServiceImpl(@Qualifier("changeNotificationJmsTemplate") JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void publishChanges(String changeNotification) {
        LOGGER.info("================Sending change notification as a simple text message=========================");

        jmsTemplate.send(CHANGE_NOTIFICATION_QUEUE, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(changeNotification);
            }
        });

        LOGGER.info("================Done Sending change notification as a simple text message====================");
    }
}
