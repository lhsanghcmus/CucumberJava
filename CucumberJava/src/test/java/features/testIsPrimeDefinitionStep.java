package features;

import static org.junit.Assert.fail;

import MyMathLibrary.MyClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class testIsPrimeDefinitionStep {
	private MyClass object;
	private int result;
	@Given("^I have an object of MyClass class which has a IsPrime method$")
	public void createObject() throws Throwable {
	    object = new MyClass();
	}

	@When("^I call IsPrime with input is (\\d+)$")
	public void callMethod(int input) throws Throwable {
	   boolean tmp = object.isPrime(input);
	   if (tmp) {
		   result = 1;
	   } else {
		   result = 0;
	   }
	}

	@Then("^I will receive (\\d+)$")
	public void compareResult(int expectedResult) throws Throwable {
	    if (result != expectedResult) {
	    	fail("Return invalid value");
	    }
	}
}
