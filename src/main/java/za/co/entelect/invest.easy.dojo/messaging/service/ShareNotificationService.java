package za.co.entelect.invest.easy.dojo.messaging.service;

import za.co.entelect.invest.easy.dojo.messaging.domain.ShareCode;

public interface ShareNotificationService {
    void sendShareNotification(ShareCode code, Integer price);
}
