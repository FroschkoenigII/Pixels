package pixels.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jni.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class GreetingServicePactTest {
	
	@Rule
    public PactProviderRuleMk2  provider = new PactProviderRuleMk2("exampleProvider","localhost",8020,this);
	
	@Pact(provider = "exampleProvider", consumer = "exampleConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");

        PactDslJsonBody body = new PactDslJsonBody()
        	    .id()
        	    .stringType("content");
        
        return builder
                .given("default")
                .uponReceiving("GreetingWithQuery")
                .path("/greeting")
                .query("name=TestName")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(body)
                .toPact();
    }
	
    @Test
    @PactVerification("exampleProvider")
    public void runTest() throws IOException {
        final RestTemplate call = new RestTemplate();
        final String forEntity = call.getForObject(provider.getConfig().url() + "/greeting?name=TestName", String.class);
    }
}
