package za.co.entelect.invest.easy.dojo;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class QueuePublisher {
    private final ConnectionFactory connectionFactory;

    private final Connection connection;

    private final MessageProducer messageProducer;

    private final Session session;

    private final Destination destination;

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
