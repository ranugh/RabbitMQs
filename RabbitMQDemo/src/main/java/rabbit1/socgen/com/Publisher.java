package rabbit1.socgen.com;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	private static final String EXCHANGE_NAME = "msg.distributor";
	private static final String ROUTING_KEY = "";
	
	public static void main(String[] args) throws InterruptedException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		
		try {
			Connection conn = factory.newConnection();
			
			
			Channel channel = conn.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT,true);
			
			
			
			String q =channel.queueDeclare().getQueue();
			String q1 =channel.queueDeclare().getQueue();
			String q2 =channel.queueDeclare().getQueue();
			channel.queueBind(q, EXCHANGE_NAME, ROUTING_KEY);
			channel.queueBind(q1, EXCHANGE_NAME, ROUTING_KEY);
			channel.queueBind(q2, EXCHANGE_NAME, ROUTING_KEY);
			

			for (int i = 0; i < 10 ; i++) {
				
				
				String message="My published data : Numer :"+i;
				channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes("UTF-8"));
				System.out.println("Message is produced3!");
				Thread.sleep(1000l);
			}
			
			
			
			
			//channel.close(); 
		//conn.close();
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
