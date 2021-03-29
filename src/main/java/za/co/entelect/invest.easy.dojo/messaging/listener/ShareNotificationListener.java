package za.co.entelect.invest.easy.dojo.messaging.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import za.co.entelect.invest.easy.dojo.messaging.domain.Constants;
import za.co.entelect.invest.easy.dojo.messaging.domain.ShareNotification;

import static za.co.entelect.invest.easy.dojo.messaging.domain.Constants.NOTIFICATION_TOPIC;

@Component
@EnableJms
public class ShareNotificationListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareNotificationListener.class);

    @JmsListener(destination = NOTIFICATION_TOPIC, containerFactory = "stockMarketContainerFactory")
    public void shareAnnouncement(Message<ShareNotification> shareNotification) {
        //Process a price change share anouncement
        LOGGER.info("Received Share Notification: {}", shareNotification.getPayload());
    }

    @JmsListener(destination = NOTIFICATION_TOPIC, selector = "top40 = true", containerFactory = "stockMarketContainerFactory")
    public void topFortyShareAnnouncement(Message<ShareNotification> shareNotification) {
        //Process a top 40 share anouncement
        LOGGER.info("Received Top 40 Share Notification: {}", shareNotification.getPayload());
    }
}
