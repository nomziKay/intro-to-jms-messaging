package za.co.entelect.invest.easy.dojo.messaging.publisher;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final JmsTemplate jmsTemplate;

    public MessagePublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public void sendTextMessage(final String destination, final String message) {
        System.out.println("================Sending simple text message=========================");
        System.out.println("Destination: " + destination);
        System.out.println("Message: " + message);
        //TODO: 3. Send a simple text message using the jmsTemplate
        System.out.println("================Done sending simple text message====================");
    }

}
