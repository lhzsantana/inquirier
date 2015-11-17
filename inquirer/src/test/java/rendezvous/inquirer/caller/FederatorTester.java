package rendezvous.inquirer.caller;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.TestCase;

public class FederatorTester extends TestCase {

	final static Logger logger = Logger.getLogger(FederatorTester.class);
	
	@Test
	public void testGet(){
		FederatorCaller caller = new FederatorCaller("http://localhost:8085/");
		caller.get("1");
	}


	@Test
	public void testPutMapping() throws IOException{
		FederatorCaller caller = new FederatorCaller("http://localhost:8085/");

		
		FileInputStream inputStream = new FileInputStream("mappings.yml");
		String mapping = IOUtils.toString(inputStream);
		
		caller.putMapping(mapping);
	}

	@Test
	public void testInsert(){
		FederatorCaller caller = new FederatorCaller("http://localhost:8085/");
		caller.insert("{}");
	}
	
	@Test
	public void testQuery(){
		FederatorCaller caller = new FederatorCaller("http://localhost:8085/");
		caller.query("{}");
	}
}
