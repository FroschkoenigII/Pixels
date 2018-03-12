package pixels.webserver.hello.pact;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import pixels.webserver.hello.Application;

@RunWith(PactRunner.class)
@Provider("exampleProvider")
@PactFolder("src/main/resources/contracts")
@VerificationReports({"console", "markdown"})
public class contractTest {
    private static ConfigurableApplicationContext application;
    
    @TestTarget
    public final Target target = new HttpTarget(8080);
    
    @BeforeClass
    public static void startSpring(){
        application = SpringApplication.run(Application.class);
    }

    @State("default")
    public void toDefaultState() {
        System.out.println("Now service in default state");
    }

    @State("extra")
    public void toExtraState() {
        System.out.println("Now service in extra state");
    }

    @AfterClass
    public static void kill(){
        application.stop();
    }
}