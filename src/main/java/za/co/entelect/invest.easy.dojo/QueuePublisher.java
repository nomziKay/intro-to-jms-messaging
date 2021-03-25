package za.co.entelect.invest.easy.dojo;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import java.util.Scanner;

public class QueuePublisher {
    private final Connection connection;

    private final MessageProducer messageProducer;

    private final Session session;

    public QueuePublisher() throws JMSException {
        System.out.println("Initializing JMS connection");

        //Initialize JMS Connection

        System.out.println("Initialization Complete");
    }

    public void publishMessage(String message) throws JMSException {
        //Send Message
    }

    public void closeConnection() throws JMSException {
        System.out.println("Closing JMS connection");
    }

    public static void main(String[] args) throws JMSException {
        QueuePublisher queuePublisher = new QueuePublisher();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a message: ");
            String message = scanner.nextLine();
            queuePublisher.publishMessage(message);
        } catch (Exception e) {
            System.out.println(String.format("Caught exception %s. %s", e.getClass().getCanonicalName(), e.getMessage()));
        } finally {
            queuePublisher.closeConnection();
        }
    }
}
