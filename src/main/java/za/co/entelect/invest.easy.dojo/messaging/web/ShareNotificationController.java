package za.co.entelect.invest.easy.dojo.messaging.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.entelect.invest.easy.dojo.messaging.domain.ShareCode;
import za.co.entelect.invest.easy.dojo.messaging.service.ShareNotificationService;

@RestController
public class ShareNotificationController {

    private ShareNotificationService shareNotificationService;

    @Autowired
    public ShareNotificationController(ShareNotificationService shareNotificationService) {
        this.shareNotificationService = shareNotificationService;
    }

    @PostMapping("/share-price/{code}/{price}")
    public String sendSharePriceChange(@PathVariable("code") ShareCode code, @PathVariable("price") Integer price) {
        shareNotificationService.sendShareNotification(code, price);
        return "Success";
    }
}
