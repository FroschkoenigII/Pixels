package pixels.webserver.someEpic.somefeature.somestory.sometask;

import static org.junit.Assert.assertEquals;
import net.thucydides.core.annotations.Step;

public class storySteps {

	@Step
	public void doSomeStep()
	{
	int a = 1+1;	
	}
	
	@Step
	public void doSomeOtherStep()
	{
	int a = 1+1;	
	}
	
	@Step
	public void doSomeStepThatIncludesOtherSteps()
	{
	doSomeStep();	
	}
	
	@Step
	public void doSomeStepWithError()
	{
	assertEquals(1, 2);
	}
	
}
