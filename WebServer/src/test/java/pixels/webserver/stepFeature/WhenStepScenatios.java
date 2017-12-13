package pixels.webserver.stepFeature;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class WhenStepScenatios {

	@Steps
	SomeSteps ss;
	
	@Test
	public void Scenatio1()
	{
		ss.doSomeOtherStep();
		ss.doSomeStepThatIncludesOtherSteps();
		ss.doSomeStep();
	}
	
	@Test
	public void Scenatio2()
	{
		ss.doSomeStep();
		ss.doSomeStep();
		ss.doSomeOtherStep();
	}
	
	@Test
	public void ScenatioWithError()
	{
		ss.doSomeOtherStep();
		ss.doSomeStepThatIncludesOtherSteps();
		ss.doSomeStep();
		ss.doSomeStepWithError();
		ss.doSomeStep();
	}
}
