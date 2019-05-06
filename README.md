# JMSLearning

1) JMS is like JDBC. Just like JDBC has all specification defined to connect to any databases , JMS also has specifications defined to communicate with any mom(Message oriented middleware) like activeMQ or websphereMQ.

2) why messaging?
    ->Heterogenous Integration: helps communicate with different services without all beign in same language or os.
    -> loosely coupled services: this helps services loosely coupled
    -> Reduces System Bottlenecks: can send message asyncronously to the consumers. If there are tons of messages in queue to a service then we can spun up multiple service so that messages can be sent asyncronously to the new instances. THis increases scalability.
    
 3) Flexibility and agility: Any changes in the services producing or consumer can be changed or replaced by new services as long as the contract between services remain the same.
 
 -------------------------------------
 Installing activemq artemis: 1) Download, 2) go to bin directory, 3) ./artemis create filepathtowhereyouwanttocreatebroker,
 4) go to bin directory of the broker, 5)./artemis run to start the broker.
 
 
 ---------------------------------
 Few need to know concept
 Connection Factory: provided to us by JMS provider like activemq
 Destination: we use jms prvider to create a destination which could be a queue or a topic
 Jms provider creates connectionfactory adn destination and  puts them in to JNDI(Java naming directory interface) registary.
 
 Connection: Connection can be created using connection factory.
 Session: From connection we can create a session.
 
 -----------------------------JMS2-----------------------------------------
 Jms2 has JMSContext which bind Connection + Session making it easier for us to create producer and consumer.
 THese jmSproducer and consumer also auto close the session and connection when pub-sub is completed.
 They also give easy access to the message header, body and properties.
 
---------------------------------------------------
JMS message is divided into three parts:
1) MessageHeader : These are the metadata that conveys sth about the message. These are also divided in to two types:
    a) Providers set headers
    b) Developer set headers
2) Messge Properties
3) MessageBody/Payload
