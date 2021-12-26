package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetWeather {

	public static void getWeather(WeatherBean wBean) throws IOException {

		// Build the API call URL by adding city+country into a URL
		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCity() + ","
				+ wBean.getCountry() + "&APPID=0b1fc4a863dbe9ca25032ffe077d9017&mode=xml";

		// print and test in a browser
		System.out.println(URLtoSend);
		// Set the URL that will be sent
		URL line_api_url = new URL(URLtoSend);

		// Create a HTTP connection to sent the GET request over
		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		// Make a Buffer to read the response from the API
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		// a String to temp save each line in the response
		String inputLine;

		// a String to save the full response to use later
		String ApiResponse = "";

		// loop through the whole response
		while ((inputLine = in.readLine()) != null) {

			// System.out.println(inputLine);
			// Save the temp line into the full response
			ApiResponse += inputLine;
		}
		in.close();

		// print the response
		//System.out.println(ApiResponse);

		// Call a method to make a XMLdoc out of the full response
		Document doc = convertStringToXMLDocument(ApiResponse);

		// normalize the XML response
		doc.getDocumentElement().normalize();
		// check that the XML response is OK by getting the Root element
		//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		wBean.setDescription(getElementString("weather", wBean, doc,"value"));
		wBean.setTemperature(getElementString("temperature", wBean, doc, "value"));
		wBean.setClouds(getElementString("clouds", wBean, doc, "name"));
		wBean.setPrecipitation(getElementString("precipitation",wBean, doc, "mode"));
		String iconID = getElementString("weather", wBean, doc,"icon");
		wBean.generateIcon(iconID);
	}
	
	private static String getElementString (String element, WeatherBean wBean, Document doc, String attributeType) {
		NodeList nList = doc.getElementsByTagName(element);
		
		// loop through the content of the tag
		for (int i = 0; i < nList.getLength(); i++) {
			// Save a node of the current list id
			Node node = nList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
			
				String stringToSend = eElement.getAttribute(attributeType);
				// and print it
				//System.out.println(wBean.getCityStr() + " is now " + XMLclouds);
				// save it
				
				return stringToSend;
				
			}
		}
		String fail="Failed to get property";
		return fail;
	}

	// Method the makes a XML doc out of a string, if it is in a XML format.
	private static Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
