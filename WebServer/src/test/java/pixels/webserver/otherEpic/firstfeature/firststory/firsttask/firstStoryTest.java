package pixels.webserver.otherEpic.firstfeature.firststory.firsttask;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class firstStoryTest {

	@Steps
	SomeSteps ss;
	
	@Test
	public void firstStoryScenatio1()
	{
		ss.doSomeOtherStep();
		ss.doSomeStepThatIncludesOtherSteps();
		ss.doSomeStep();
	}
	
	@Test
	public void firstStoryScenatio2()
	{
		ss.doSomeStep();
		ss.doSomeStep();
		ss.doSomeOtherStep();
	}
	
	@Test
	public void firstStoryScenatioWithError()
	{
		ss.doSomeOtherStep();
		ss.doSomeStepThatIncludesOtherSteps();
		ss.doSomeStep();
		ss.doSomeStepWithError();
		ss.doSomeStep();
	}
}
