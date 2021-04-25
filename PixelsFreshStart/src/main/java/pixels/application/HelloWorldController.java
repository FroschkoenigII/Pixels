package pixels.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/")
	public String backup() {
		return "Server is running. Please try different URL";
	}

	@RequestMapping("/greeting")
	public String greeting() {
		return "Julija number One";
	}
}
