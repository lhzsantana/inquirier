package rendezvous.inquirer;

import junit.framework.TestCase;

public class InquirerAppTest extends TestCase {

	InquirerApp app = new InquirerApp();
	
	public void testQuery() {
		app.query("PREFIX foaf: " + 
				"<http://xmlns.com/foaf/0.1/> SELECT ?name ?mbox WHERE " +
				"{ ?x foaf:name ?name . ?x foaf:mbox ?mbox }");
	}

}
