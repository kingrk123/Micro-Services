package in.nit.service.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import in.nit.MessageStorage;

@Component
public class ConsumerService {
	
	private Logger log = LoggerFactory.getLogger(ConsumerService.class);
	
	@Autowired
	private MessageStorage ms;
	
	@KafkaListener(topics = "${my.app.tpc}", groupId = "groupId")
	public void consumeMessage(String message) {
		log.info("CONSUMER RECEIVED MESSAGE IS=>"+message);
		ms.putMsg(message);
	}
}

