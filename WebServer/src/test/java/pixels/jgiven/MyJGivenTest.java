package pixels.jgiven;

import org.junit.Test;

import com.tngtech.jgiven.junit.ScenarioTest;


@EgpIssue(value = "TestIssue")
public class MyJGivenTest  extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {


	@Test
    public void something_should_happen() {
        given().some_state();
        when().some_action();
        then().some_outcome();
    }
    
    @Test
    public void something_should_not_happen() {
        given().some_impossible_state();
        when().some_action();
        then().some_outcome();
    }
    
    @Test
    public void something_should_share() {
        given().some_valuesetting_state();
        when().some_action();
        then().some_shared_value_is_shared();
    }
    
    @Test
    public void something_should_share_and_something_else() {
        given().some_valuesetting_state().and().some_state();
        when().some_action();
        then().some_shared_value_is_shared().and().some_outcome();
    }
    
    @Test
    public void something_should_work() {
        given().some_valuesetting_state().but().some_impossible_state();
        when().some_action();
        then().some_outcome();
    }
}