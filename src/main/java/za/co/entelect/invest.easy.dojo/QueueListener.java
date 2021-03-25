package za.co.entelect.invest.easy.dojo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueListener implements MessageListener {

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

        messageConsumer.setMessageListener(this);

        System.out.println("Initialization Complete");
    }

    public void finalize() throws Throwable {
        System.out.println("Closing JMS connection");
        connection.close();
    }

    public static void main(String[] args) throws JMSException {
        QueueListener queueListener = new QueueListener();
        System.out.println("Program can continue to perform other tasks here...");
    }

    public void onMessage(Message message) {

        if (!(message instanceof TextMessage)) {
            System.out.println("Not a TextMessage, discarding");
            return;
        }

        try {
            //process message
            System.out.println(message.getJMSMessageID());
            System.out.println(((TextMessage) message).getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
