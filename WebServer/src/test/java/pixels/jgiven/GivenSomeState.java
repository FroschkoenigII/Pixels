package pixels.jgiven;

import static org.junit.Assert.assertEquals;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;

public class GivenSomeState extends Stage<GivenSomeState> {

	@ScenarioState
	int sharedValue;

	public GivenSomeState some_state() {
		return self();
	}

	public GivenSomeState some_impossible_state() {
		assertEquals(1, 0);
		return self();
	}
	
	public GivenSomeState some_valuesetting_state() {
		sharedValue= 4;
		return self();
	}
}