package za.co.entelect.invest.easy.dojo.messaging.service;

public interface InvestEasyChangeNotificationService {

    void publishChanges(String changes);

    void convertAndSendMessage(String key, String value);
}
