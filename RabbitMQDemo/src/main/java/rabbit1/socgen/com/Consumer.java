package rabbit1.socgen.com;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {

  private static final String ROUTING_KEY = "";
  
  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    String q =channel.queueDeclare().getQueue();
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    
    
    
    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
    };
    
   
   // channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

  }
}