package controllers;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// for reading out the file specifically
public class FileParser {
	// Initialising variables
	private static JSONParser parser = new JSONParser();

	public static JSONObject dataSetter() {
		try {
			//Read json file as object
			Object obj = parser.parse(new FileReader("conf/cities.json"));

			//Cast as JSONObject
			JSONObject jsonCities = (JSONObject) obj;
			
			return jsonCities;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
