package za.co.entelect.invest.easy.dojo.messaging.service;

public interface PublishingService {

    void publishChanges(String changes);

    void convertAndSendMessage(String key, String value);
}
