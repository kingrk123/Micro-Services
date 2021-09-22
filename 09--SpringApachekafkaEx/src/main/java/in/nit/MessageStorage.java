package in.nit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStorage {

private List<String> list = new ArrayList<>();
	
	public void putMsg(String message) {
		list.add(message);
	}
	
	public String getMessages() {
		return list.toString();
	}
}
