package za.co.entelect.invest.easy.dojo;

import javax.jms.*;

public class QueueListener {
    //private final ConnectionFactory connectionFactory;

    //private final Connection connection;

    //private final MessageConsumer messageConsumer;

    //private final Session session;

    //private final Destination destination;

    public QueueListener() throws JMSException {
        System.out.println("Initializing JMS connection");

        //Initialize JMS Connection factory

        //Initialize JMS Connection

        //Initialize JMS session

        //Initialize Destination

        //Initialize MessageConsumer

        //Start Connection

        System.out.println("Initialization Complete");
    }

    public void listen() throws JMSException {

    }

    public void closeConnection() throws JMSException {
        System.out.println("Closing JMS connection");
        //Close connection
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
