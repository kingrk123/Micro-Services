package in.nit;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ProducerRunner  
{
	@Autowired
	private JmsTemplate jt;
	@Value("${my.tpc.name}")
	private String destinationName;
	
	//public void run(String... args) throws Exception {
	@Scheduled(fixedDelay = 5000)	
	public void send() {	
		System.out.println("Producer Started...");
		String text="Hello from Producer App..."+new Date();
		
		//interface ob = (params) -> {body};
		//JDK 1.8 Lambda Expression
		MessageCreator messageCreator = (ses) -> {
			  return ses.createTextMessage(text);	
		};
		
		//Anonymouse Inner class
		/*MessageCreator messageCreator = new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) 
					throws JMSException {
				return session.createTextMessage(text);
			}
		};*/
		
		jt.send(destinationName, messageCreator);
	}


}
