package pixels.webserver.hello;

import org.junit.Test;

import com.tngtech.jgiven.junit.SimpleScenarioTest;

import pixels.webserver.hello.jgiven.exampleStage;

public class exampleJGivenTest extends SimpleScenarioTest<exampleStage> {

	@Test
	public void exampleTest() {
		given().something().and().something_else();
		when().something().but().something_else();
		then().something_to_end();
	}

	@Test
	public void otherExampleTest() {
		given().something().and().something_else();
		when().something().but().something_else();
		then().something_to_end();
	}

}
