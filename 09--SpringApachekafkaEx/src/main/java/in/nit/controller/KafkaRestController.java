package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nit.MessageStorage;
import in.nit.service.producer.ProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {

private Logger log = LoggerFactory.getLogger(KafkaRestController.class);
	
	@Autowired
	private MessageStorage ms;
	
	@Autowired
	private ProducerService producer;
	
	//1. read message and send to producer application
	//...../send?message=___
	@GetMapping("/send")
	public String sendMsg(
				@RequestParam String message) 
	{
		log.info("ABOUT TO CALL CONSUMER");
		producer.sendMessage(message);
		log.info("MESSAGE SENT USING CONSUMER=>"+message);
		return "DONE";
	}
	
	
	//2. read all messages from MessageStore
	@GetMapping("/all")
	public String getAll() {
		log.info("ABOUT TO READ ALL MESSAGES");
		String messages = ms.getMessages();
		return messages;
	}

}
