package za.co.entelect.invest.easy.dojo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class QueuePublisher {
    private final Connection connection;

    private final MessageProducer messageProducer;

    private final Session session;

    public QueuePublisher() throws JMSException {
        System.out.println("Initializing JMS connection");
        //ActiveMQConnectionFactory.DEFAULT_BROKER_URL = tcp://localhost:61616
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination writeDestination = session.createQueue("Q.za.co.entelect.dojo.jms");

        messageProducer = session.createProducer(writeDestination);

        connection.start();

        System.out.println("Initialization Complete");
    }

    public void publishMessage(String message) throws JMSException {
        Message jmsMessage = session.createTextMessage(message);
        messageProducer.send(jmsMessage);
    }

    public void closeConnection() throws JMSException {
        System.out.println("Closing JMS connection");
        connection.close();
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
