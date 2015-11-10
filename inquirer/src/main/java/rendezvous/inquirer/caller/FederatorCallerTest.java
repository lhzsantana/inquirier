package rendezvous.inquirer.caller;

import junit.framework.TestCase;

public class FederatorCallerTest extends TestCase {
	
	FederatorCaller caller = new FederatorCaller("http://localhost/");

	public void testPutMapping() {
		
		caller.putMapping("");
	}

	public void testInsert() {

		caller.putMapping("");
		
		caller.insert("");
	}

	public void testQuery() {
		
		caller.putMapping("");
		caller.insert("");
		caller.query("");
		
	}
}
