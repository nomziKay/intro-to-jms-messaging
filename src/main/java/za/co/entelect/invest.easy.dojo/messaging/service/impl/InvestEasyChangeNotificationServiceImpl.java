package za.co.entelect.invest.easy.dojo.messaging.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import za.co.entelect.invest.easy.dojo.messaging.service.InvestEasyChangeNotificationService;

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

        //TODO: 3. Send a simple text message using the jmsTemplate


        LOGGER.info("================Done Sending change notification as a simple text message====================");
    }
}
