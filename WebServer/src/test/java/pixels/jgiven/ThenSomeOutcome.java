package pixels.jgiven;

import static org.junit.Assert.assertEquals;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
	
	@ScenarioState
	int sharedValue;
	
    public ThenSomeOutcome some_outcome() {
        return self();
    }
    
    
    
    public ThenSomeOutcome some_shared_value_is_shared() {
    	assertEquals(4, sharedValue);
        return self();
    }
}