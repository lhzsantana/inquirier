package rendezvous.inquirer.caller;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class FederatorCaller {

	final static Logger logger = Logger.getLogger(FederatorTester.class);

	private String baseURL = null;

	public FederatorCaller(String baseURL) {
		this.baseURL = baseURL;
	}

	private WebResource createClient(String endpoint) {

		try {
			Client client = Client.create();

			String url = this.baseURL + endpoint;

			logger.info("The server url is " + url);

			WebResource webResource = client.resource(this.baseURL + endpoint);

			return webResource;

		} catch (Exception e) {
			logger.error(e);
		}

		return null;
	}

	public void putMapping(String mapping) {

		try {

			ClientResponse response = createClient("_mapping").type("application/json").put(ClientResponse.class,
					mapping);

			logger.info("The server response is" + response.toString());

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

		} catch (Exception e) {
			logger.error(e);
		}
	}

	public String insert(String entity) {

		try {
			ClientResponse response = createClient("_insert").type("application/json").post(ClientResponse.class,
					entity);

			logger.info("The server response is" + response.toString());

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			return response.toString();

		} catch (Exception e) {
			logger.error(e);
		}

		return null;
	}

	public String query(String query) {

		try {
			ClientResponse response = createClient("_query").type("application/json").post(ClientResponse.class, query);

			logger.info("The server response is" + response.toString());

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			return response.toString();

		} catch (Exception e) {
			logger.error(e);
		}

		return null;
	}

	public void get(String id) {
		
		try {
			
			ClientResponse response = createClient("_get/" + id).type("application/json").get(ClientResponse.class);

			logger.info("The server response is" + response.toString());

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

		} catch (Exception e) {
			logger.error(e);
		}
	}
}
