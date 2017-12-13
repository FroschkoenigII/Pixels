package pixels.webserver.hello;

import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;

@RunWith(SerenityRunner.class)
public class TravellerStatusSteps extends TravellerSteps {                  

    @Step                                                                   
    public void a_traveller_joins_the_frequent_flyer_program() {
        frequentFlyer = FrequentFlyer.withInitialBalanceOf(0);
    }

    @Step("The traveller should have {0} status")                           
    public void traveller_should_have_a_status_of(String expectedStatus) {
       assertEquals(expectedStatus,this.frequentFlyer.getStatus());
    }
}