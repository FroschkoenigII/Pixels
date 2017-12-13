package pixels.webserver.someEpic.somefeature.somestory.sometask;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class someStoryTest {

	@Steps
	storySteps ss;
	
	@Test
	@Title("Szenario mit verweis auf eine JiraIssue: #EGPU-7165")
	public void someStoryScenatio1()
	{
		ss.doSomeOtherStep();
		ss.doSomeStepThatIncludesOtherSteps();
		ss.doSomeStep();
	}
	
	@Test
	public void someStoryScenatio2()
	{
		ss.doSomeStep();
		ss.doSomeStep();
		ss.doSomeOtherStep();
	}
	
	@Test
	public void someStoryScenatioWithError()
	{
		ss.doSomeOtherStep();
		ss.doSomeStepThatIncludesOtherSteps();
		ss.doSomeStep();
		ss.doSomeStepWithError();
		ss.doSomeStep();
	}
	
	@Test
	@Pending
	public void someStoryScenatioWithErrorPending()
	{
		ss.doSomeOtherStep();
		ss.doSomeStepThatIncludesOtherSteps();
		ss.doSomeStep();
		ss.doSomeStepWithError();
		ss.doSomeStep();
	}
	
	@Test
	@Ignore
	public void someStoryScenatioWithErrorIgnored()
	{
		ss.doSomeOtherStep();
		ss.doSomeStepThatIncludesOtherSteps();
		ss.doSomeStep();
		ss.doSomeStepWithError();
		ss.doSomeStep();
	}
	
}
