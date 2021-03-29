package za.co.entelect.invest.easy.dojo.messaging.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.entelect.invest.easy.dojo.messaging.domain.ShareCode;
import za.co.entelect.invest.easy.dojo.messaging.service.InvestEasyChangeNotificationService;
import za.co.entelect.invest.easy.dojo.messaging.service.ShareNotificationService;

@RestController
public class ShareNotificationController {

    private final InvestEasyChangeNotificationService investEasyChangeNotificationService;
    private final ShareNotificationService shareNotificationService;

    public ShareNotificationController(InvestEasyChangeNotificationService investEasyChangeNotificationService, ShareNotificationService shareNotificationService) {
        this.investEasyChangeNotificationService = investEasyChangeNotificationService;
        this.shareNotificationService = shareNotificationService;
    }

    @PostMapping("/share-price/{code}/{price}")
    public String sendSharePriceChange(@PathVariable("code") ShareCode code, @PathVariable("price") Integer price) {
        investEasyChangeNotificationService.publishChanges("There were changes to the following share: " + code.getDescription() + ", new price: " + price);
        shareNotificationService.sendShareNotification(code, price);
        return "Success";
    }
}
