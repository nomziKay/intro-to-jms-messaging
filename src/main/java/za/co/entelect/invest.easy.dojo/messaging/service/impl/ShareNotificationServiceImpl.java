package za.co.entelect.invest.easy.dojo.messaging.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;
import za.co.entelect.invest.easy.dojo.messaging.domain.Constants;
import za.co.entelect.invest.easy.dojo.messaging.domain.ShareCode;
import za.co.entelect.invest.easy.dojo.messaging.domain.ShareNotification;
import za.co.entelect.invest.easy.dojo.messaging.service.ShareNotificationService;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.EnumMap;
import java.util.Map;

import static za.co.entelect.invest.easy.dojo.messaging.domain.Constants.NOTIFICATION_TOPIC;

@Service
public class ShareNotificationServiceImpl implements ShareNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareNotificationServiceImpl.class);

    private JmsTemplate jmsTemplate;

    private static final Map<ShareCode, Integer> CODE_PRICE_MAP = new EnumMap<ShareCode, Integer>(ShareCode.class);

    @Autowired
    public ShareNotificationServiceImpl(@Qualifier("easyInvestJmsTemplate") JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        CODE_PRICE_MAP.put(ShareCode.DSY, 2500);
        CODE_PRICE_MAP.put(ShareCode.MTN, 1700);
    }

    @Override
    public void sendShareNotification(ShareCode code, Integer price) {
        LOGGER.info("================Converting & Sending ShareNotification to Topic===================");
        jmsTemplate.convertAndSend(NOTIFICATION_TOPIC, new ShareNotification(code, price, CODE_PRICE_MAP.get(code)), new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setBooleanProperty("top40", code.getTop40());
                return message;
            }
        });
        CODE_PRICE_MAP.put(code, price);
        LOGGER.info("================Done Converting & Sending ShareNotification to Topic===============");
    }
}
