package za.co.entelect.invest.easy.dojo.messaging.shell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import za.co.entelect.invest.easy.dojo.messaging.service.InvestEasyChangeNotificationService;


@ShellComponent
public class MessagingCLI {

    private InvestEasyChangeNotificationService investEasyChangeNotificationService;

    public MessagingCLI(InvestEasyChangeNotificationService investEasyChangeNotificationService) {
        this.investEasyChangeNotificationService = investEasyChangeNotificationService;
    }

    @ShellMethod("Sends a text message to the destination queue")
    public void send(
            @ShellOption String textMessage
    ){
        investEasyChangeNotificationService.publishChanges(textMessage);
    }
}
