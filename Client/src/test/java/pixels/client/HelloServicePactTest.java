package pixels.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class HelloServicePactTest {
	
	@Rule
    public PactProviderRuleMk2  provider = new PactProviderRuleMk2("exampleProvider","localhost",8020,this);
	
	@Pact(provider = "exampleProvider", consumer = "exampleConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "text/plain");

        return builder
                .given("default")
                .uponReceiving("HelloRequest")
                .path("/")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("Greetings from Spring Boot!")
                .toPact();
    }
	
    @Test
    @PactVerification("exampleProvider")
    public void runTest() throws IOException {
        final RestTemplate call = new RestTemplate();
        //final Greeting expectedResponse = new Greeting(1, "Hello, sven!");
        String expectedResult = "Greetings from Spring Boot!";
        final String forEntity = call.getForObject(provider.getConfig().url() + "/", String.class);
        org.junit.Assert.assertEquals(expectedResult,forEntity);

    }
}
