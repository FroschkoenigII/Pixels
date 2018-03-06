package pixels.webserver.hello;

import org.junit.Before;

import io.restassured.module.mockmvc.RestAssuredMockMvc;



public class MvcTest {
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(new GreetingController());
	}
}
