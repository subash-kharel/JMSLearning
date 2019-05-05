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
