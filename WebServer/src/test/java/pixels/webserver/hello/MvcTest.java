package pixels.webserver.hello;

import org.junit.Before;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import pixels.webserver.hello.HelloController;

public class MvcTest {
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(new HelloController());
	}
}