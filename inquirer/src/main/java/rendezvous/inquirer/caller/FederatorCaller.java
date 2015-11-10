package rendezvous.inquirer.caller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class FederatorCaller {

	String baseURL = null;

	public FederatorCaller(String baseURL) {
		this.baseURL = baseURL;
	}

	private WebResource createClient(String endpoint) {

		Client client = Client.create();

		WebResource webResource = client.resource(baseURL + endpoint);

		return webResource;

	}

	public void putMapping(String mapping) {

		ClientResponse response = createClient("_mapping").type("application/json").post(ClientResponse.class, mapping);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
	}

	public String insert(String entity) {

		ClientResponse response = createClient("_insert").type("application/json").post(ClientResponse.class, entity);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		return response.toString();
	}

	public String query(String query) {

		ClientResponse response = createClient("_query").type("application/json").post(ClientResponse.class, query);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		return response.toString();
	}
}
