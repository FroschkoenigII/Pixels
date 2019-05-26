package pixels.examples.helloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/greeting")
	public String greeting() {
		return "Julija is the Sweetest girl there is :-*";
	}
}
