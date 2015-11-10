package rendezvous.inquirer;

import java.util.List;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;

import rendezvous.jena.DistributedModel;
import rendezvous.jena.DistributedModelFactory;

public class InquirerApp {
	
	public List<Triple> query(String query) {

		QueryExecution qe = QueryExecutionFactory.create(query);

		return null;
	}
	
	public void insert(Resource subject, Property predicate, RDFNode object){
		
		DistributedModel model = DistributedModelFactory.createOntologyModel();
		
		Statement s = ResourceFactory.createStatement(subject, predicate, object);
		
		model.add(s);
	}

}
