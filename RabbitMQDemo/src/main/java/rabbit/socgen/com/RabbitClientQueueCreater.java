package rabbit.socgen.com;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitClientQueueCreater {
	private static final String QUEUE_NAME = "SGQueue";
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		
		try {
			Connection conn = factory.newConnection();
			
			
			Channel channel = conn.createChannel();
			channel.queueDeclare(QUEUE_NAME, true,false, false, null);
			System.out.println(QUEUE_NAME + " Created!");
			channel.close();
			conn.close();
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
