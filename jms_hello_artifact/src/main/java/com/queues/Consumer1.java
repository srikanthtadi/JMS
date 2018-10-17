package com.queues;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer1 {


	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;


	public static void main(String[] args) {

		ConnectionFactory cf = null;
		Connection c = null;
		Session s = null;

		try {
			cf = new ActiveMQConnectionFactory(url);
			c = cf.createConnection();
			
			
			s = c.createSession(true, Session.AUTO_ACKNOWLEDGE);

			Destination d = s.createQueue("jms/fristQueue");

			MessageConsumer mcon = s.createConsumer(d);
			
			mcon.setMessageListener(new Listener1());
			c.start();
			
			while(true)
				Thread.sleep(10000);
			 
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally {

			if(c != null)
				try {
					c.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}

}


class Listener1 implements MessageListener{

	public void onMessage(Message m) {
		// TODO Auto-generated method stub
		
		
		System.out.println("inside on message in listener 1");
		if(m instanceof TextMessage )
		{
			TextMessage  t = (TextMessage) m;
			
			try {
				System.out.println(t.getText());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
