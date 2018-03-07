package pixels.webserver.hello;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import scala.util.parsing.json.JSON;

public class PactLocalizer {

	private static final String PACTURL = "http://localhost/pacts/provider/exampleProvider/latest";

	private static final String providerName = "exampleProvider";

	public static void main(String[] args) throws Exception {

		
		JSONObject pactLocations = readJsonFromURL(PACTURL);

		JSONObject pacts = pactLocations.getJSONObject("_links");

		JSONArray pactss = pacts.getJSONArray("pacts");
		pactss.forEach(p -> {
			try {
				generatePact(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

	private static void generatePact(Object p) throws Exception {
		JSONObject jo = (JSONObject) p;
		String consumerName = (String) jo.get("name");
		String pactURL = (String) jo.get("href");
		JSONObject finalPact = sendGet(pactURL,true);
		writeToFile(finalPact, consumerName);
	}

	private static void writeToFile(JSONObject finalPact, String consumerName) throws IOException {
		try (FileWriter file = new FileWriter("target/pact/contracts/" + consumerName + "-" + providerName + ".json")) {
			file.write(finalPact.toString());
			System.out.println("Successfully Copied JSON Object to File...");
		}

	}

	private static JSONObject readJsonFromURL(String URL) throws IOException {
		URL address = new URL(URL);
		HttpURLConnection hc = (HttpURLConnection) address.openConnection();

		hc.setDoOutput(true);
		hc.setDoInput(true);
		hc.setUseCaches(false);
		hc.setRequestMethod("GET");
		hc.setRequestProperty("Accept","application/json");
		InputStream is = new URL(URL).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	// HTTP GET request
	private static JSONObject sendGet(String url,boolean JSONHeader) throws Exception {
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		// add request header
		if(JSONHeader)
		con.setRequestProperty("Accept","application/json");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		JSONObject json = new JSONObject(response);
		return json;


	}

}
