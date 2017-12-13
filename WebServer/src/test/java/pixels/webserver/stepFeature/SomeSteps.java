package pixels.webserver.stepFeature;

import static org.junit.Assert.assertEquals;

import net.thucydides.core.annotations.Step;

public class SomeSteps {

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
