package pixels.client;

public class exampleFunction {

	private RestRequest request = null;

	public void execute() {

		request.callURL("http://localhost:8090/");

		request.callURL("http://localhost:8090/greeting");

		request.callURL("http://localhost:8090/greeting?name=testName");
	}
	
	public RestRequest getRequest() {
		return request;
	}


	public void setRequest(RestRequest request) {
		this.request = request;
	}
}
