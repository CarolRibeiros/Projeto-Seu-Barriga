package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailGenerator {
	
	public String EmailGenerator() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatado = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String data = dateTime.format(formatado);
		String email = data + "@gmail.com";
		return email;
	}
	

}
