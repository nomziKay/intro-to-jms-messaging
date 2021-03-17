package za.co.entelect.invest.easy.dojo.messaging.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import za.co.entelect.invest.easy.dojo.messaging.publisher.MessagePublisher;
import za.co.entelect.invest.easy.dojo.messaging.service.PublishingService;

import java.util.HashMap;
import java.util.Map;

@Service
public class PublishingServiceImpl implements PublishingService {

    private final MessagePublisher messagePublisher;

    @Value("Q.za.co.entelect.dojo.jms")
    private String queueName;

    public PublishingServiceImpl(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @Override
    public void publishChanges(String changes) {
        messagePublisher.sendTextMessage(queueName, changes);
    }

    @Override
    public void convertAndSendMessage(String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        messagePublisher.sendConvertedTextMessage(queueName, map);
    }
}
