package za.co.entelect.invest.easy.dojo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueListener {

    private final Connection connection;

    private final MessageConsumer messageConsumer;

    public QueueListener() throws JMSException {
        System.out.println("Initializing JMS connection");
        //ActiveMQConnectionFactory.DEFAULT_BROKER_URL = tcp://localhost:61616
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination readDestination = session.createQueue("Q.za.co.entelect.dojo.jms");

        messageConsumer = session.createConsumer(readDestination);

        connection.start();

        System.out.println("Initialization Complete");
    }

    public void listen() throws JMSException {
        Message message = null;
        while (true) {
            System.out.println("Listening for message...");
            message = messageConsumer.receive(20000L);

            if (message == null) {
                System.out.println("Didn't read anything from queue in 20 seconds. Terminating");
                break;
            }

            if (!(message instanceof TextMessage)) {
                System.out.println("Not a TextMessage, discarding");
                continue;
            }

            //process message
            System.out.println(message.getJMSMessageID());
            System.out.println(((TextMessage) message).getText());
        }
    }

    public void closeConnection() throws JMSException {
        System.out.println("Closing JMS connection");
        connection.close();
    }

    public static void main(String[] args) throws JMSException {
        QueueListener queueListener = new QueueListener();
        try {
            queueListener.listen();
        } catch (Exception e) {
            System.out.println(String.format("Caught exception %s. %s", e.getClass().getCanonicalName(), e.getMessage()));
        } finally {
            queueListener.closeConnection();
        }
    }
}
