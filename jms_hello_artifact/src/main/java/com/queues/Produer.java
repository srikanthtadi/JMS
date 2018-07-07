package com.queues;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Produer {
	
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	
 public static void main(String[] args)  {
	 
	 ConnectionFactory cf = null;
	 Connection c = null;
	 
	 
	 Session s = null;
	 
	 try {
		  cf = new ActiveMQConnectionFactory(url);
		  c = cf.createConnection();
		 c.start();
		 
		  s = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 
	 Destination d = s.createQueue("jms/fristQueue");
	 
	MessageProducer p =  s.createProducer(d);
	
	TextMessage  t  = s.createTextMessage("Hi.. This is 4  message");
	
	p.send(t);
	System.out.println("message sent");
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
