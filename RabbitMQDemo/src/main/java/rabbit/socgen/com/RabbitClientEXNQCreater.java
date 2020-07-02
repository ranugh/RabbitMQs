package rabbit.socgen.com;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitClientEXNQCreater {
	private static final String QUEUE_NAME = "SGQueue1";
	private static final String EXCHANGE_NAME = "SGExchange1";
	private static final String ROUTING_KEY = "";
	
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		
		try {
			Connection conn = factory.newConnection();
			
			
			Channel channel = conn.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT,true);
			channel.queueDeclare(QUEUE_NAME, true,true, false, null);
			channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
			
			
			
			System.out.println(QUEUE_NAME +" | "+EXCHANGE_NAME+" | "+"Binding  Created!");
			//channel.close(); 
			//conn.close();
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
