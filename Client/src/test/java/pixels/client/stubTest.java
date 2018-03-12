package pixels.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = { "pixels.main.webserver.hello:http-server:+:stubs:8085" }, workOffline = true)
public class stubTest {

	@Test
	public void should_give_me_a_beer_when_im_old_enough() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/vnd.fraud.v1+json");
		String response = restTemplate.exchange("http://localhost:8080/fraudcheck", HttpMethod.PUT,
				new HttpEntity<>("{\"clientId\":\"1234567890\",\"loanAmount\":99999}", httpHeaders), String.class)
				.toString();
		org.junit.Assert.assertEquals(response, "abc");
	}
}