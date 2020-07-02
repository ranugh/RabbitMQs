package rabbit.socgen.com;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitClientExchangeCreater {
	private static final String EXCHANGE_NAME = "SGExchange";
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		
		try {
			Connection conn = factory.newConnection();
			
			
			Channel channel = conn.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT,true);
			System.out.println(EXCHANGE_NAME + " Created!");
			channel.close();
			conn.close();
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
