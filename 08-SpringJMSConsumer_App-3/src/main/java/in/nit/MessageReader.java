package in.nit;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReader {

	@JmsListener(
			destination = "${my.tpc.name}"
			)
	public void read(
			String text) 
	{
		System.out.println(
				"Data at consumer:=>"+text);
	}
}	