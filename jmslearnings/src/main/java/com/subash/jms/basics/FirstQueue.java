package com.subash.jms.basics;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstQueue {
	
	public static void main(String[] args) {
		InitialContext initialContext = null;
		Connection connection =null;
		
		try {
			//this instance will automatially use the info in jndi.properties which has
			//access to the jndi registry running in the server.
			initialContext = new InitialContext();
			//getting connection factory from JMS provider
			ConnectionFactory cf=(ConnectionFactory) initialContext.lookup("ConnectionFactory");
			try {
				 connection =cf.createConnection();
				Session createSession = connection.createSession();
				Queue queue =(Queue) initialContext.lookup("queue/myQueue");
				MessageProducer producer= createSession.createProducer(queue);
				TextMessage message= createSession.createTextMessage("I am being sent by producer");
				
				producer.send(message);
				System.out.println("Sent message ---->"+ message.getText());
				MessageConsumer createConsumer = createSession.createConsumer(queue);
				
				//this is necessary to tell consumenr that its ready to start consuming messages
				connection.start();
				//it will wait 5 sec adn if there is no message it will throw exception
				TextMessage receive = (TextMessage) createConsumer.receive(5000);
				System.out.println("Message Received:  "+ receive.getText());
				
				
			} catch (JMSException e) {
			
				e.printStackTrace();
			}
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		finally {
			if(initialContext!=null) {
				try {
					initialContext.close();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}if(connection !=null) {
			try {
				connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
