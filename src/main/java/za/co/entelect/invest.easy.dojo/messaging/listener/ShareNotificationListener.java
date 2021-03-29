package za.co.entelect.invest.easy.dojo.messaging.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import za.co.entelect.invest.easy.dojo.messaging.domain.Constants;
import za.co.entelect.invest.easy.dojo.messaging.domain.ShareNotification;

@Component
public class ShareNotificationListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareNotificationListener.class);
    //ToDo - Add listener methods
}
