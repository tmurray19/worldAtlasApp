package controllers;
 
import play.*;
import play.mvc.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
 
import models.*;
 
import exceptions.DataFormatException;

import play.test.*;
//import org.json.*;
import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@With(Secure.class)
public class Admin extends Controller {
    
	// Connects Admin
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.name);
        }
    }
 
    // Renders index page
    public static void index() {
        render();
    }
    
    // Renders upload page
    public static void jsonUpload() {
    	render();
    }
    
    // Uploads JSON file
    // TODO
    // Read in File from Form
    // Update file in database with file uploaded
    // Reread the updated file 
	public static void uploadJSON(File jsonData) throws UnsupportedEncodingException, IOException, ParseException {
		try {
			// Creates an inputStream for the file uploaded by user
			InputStream input = new FileInputStream(jsonData);
			// Attempts to write data to file
			cityPopulator(input);
			// Tells user upload was successful
			flash.success("File uploaded successfully.");
		} 
		
		// For catching reading and writing errors
		catch (FileNotFoundException fe) {
			flash.error("Failed to locate the uploaded JSON file.");
			fe.printStackTrace();
		} catch (DataFormatException de) {
			flash.error("Data formating error: " + de.getMessage());
			de.printStackTrace();
		} 
		jsonUpload();
    }

	
	// Overwrites data that exists in database
	private static void cityPopulator(InputStream input)	throws DataFormatException, UnsupportedEncodingException, IOException, ParseException{
		JSONParser jsonParser = new JSONParser();
		// Creates and populates jsonObject with filestreamed data from file uploaded by user
		JSONObject jsonObject = (JSONObject)jsonParser.parse(
		      new InputStreamReader(input, "UTF-8"));		// Attepmts to write data to established countries.json file
		try (FileWriter dataWriter = new FileWriter("data.json", false)) {
			dataWriter.write(jsonObject.toJSONString(jsonObject));
		}
		
	}
	
	
	
	
	

	
	
	/*

	// Here's the version given to us by you in the labs
	// I'm acknowledging that this is the model solution
	// and have updated it so that it might reflect an ideal
	// Country and City model
	@SuppressWarnings("unused")
	private static void populateDatabase(InputStream input) 
	throws DataFormatException, FileNotFoundException, JSONException {
		
		// Parse the JSON file and make sure it's not completely broken.
		JSONTokener parser = new JSONTokener(input);
		JSONObject data = new JSONObject(parser);

		// Check if file has the key "customers"
		if (!data.has("countries"))
			throw new DataFormatException("No key 'countries', file cannot be read.", data);
		
		// Load the array of customers
		JSONArray countryArray = data.getJSONArray("countries");
		
		// Check if the data for "customers" is a an array
		if (!(countryArray instanceof JSONArray))
			throw new DataFormatException("Key 'countries' must point to a JSON array.", data);
		
		
		// Loop through all countries
		for (int i = 0; i < countryArray.length(); i++) {
			JSONObject countryJSON = countryArray.getJSONObject(i);
			
			if (!(countryJSON.has("name") && countryJSON.get("name") instanceof String))
				throw new DataFormatException("All countries must be named.", data);
			
			if (!(countryJSON.has("pop") && countryJSON.get("pop") instanceof Long))
				throw new DataFormatException("Missing number for customer " + countryJSON.get("name"), data);
			

			Long countryPopulation = countryJSON.getLong("pop");
			String countryName = countryJSON.getString("name");
			
			// Check if there is already a customer with this number in database
			if (null != Country.find("byName", countryName).first())
				throw new DataFormatException("There is already an existing country with name " + countryName, data);

			// Dummy country account
			// I know how you're supposed to read the files in
			// It's supposed to be like this:
			// Country country = new Country(countryName, countryPopulation, countryCapital, countryBorders, countryCities);
			// But I defined the country class differently, and I wish to solve this assignment using my own code
			// Not just copy pasting the code your provided me
			// Even if I'll have a more 'correct' solution using your code
			Country country  = new Country("",0,"","","");
			country.save();
						
			// Scan the accounts of the current customer in JSON file
			if (countryJSON.has("bordering") && countryJSON.get("bordering") instanceof JSONArray) {

				JSONArray borderingArray = countryJSON.getJSONArray("bordering");

				for (int j = 0; j < borderingArray.length(); j++) {
					JSONObject borderingJSON = borderingArray.getJSONObject(j);

					if (!borderingJSON.has("accountNumber") && borderingJSON.get("accountNumber") instanceof Integer)
						throw new DataFormatException("Missing account number for customer " + countryName, data);

					if (!borderingJSON.has("isCurrentAccount") && borderingJSON.get("isCurrentAccount") instanceof Boolean)
						throw new DataFormatException("Missing account type for customer " + countryName, data);

					Integer accountNumber = borderingJSON.getInt("accountNumber");
					Boolean currentAccount = borderingJSON.getBoolean("isCurrentAccount");

					if (null != Country.find("byAccountNumber", accountNumber).first()) {
						throw new DataFormatException("There is already an existing account with number " + accountNumber, data);
					}

					// Create and save to database
					City city  = new City(null,"");
					city.save();

					//country.cities.add(city.getName());
					country.cities += (city.getName());
					country.save();
				}
			}
		}
		// Now that we have all the countries, deal with borders
		if (data.has("borders")) {
			JSONObject relationsJSON = data.getJSONObject("borders");
			for (String k : relationsJSON.keySet()) {
				Country c = Country.find("byName", k).first();

				if (null == c)
					throw new DataFormatException("There is no country with name " + k, data);

				JSONArray relationsArray = relationsJSON.getJSONArray(k);

				for (int i = 0; i < relationsArray.length(); i++) {
					Integer rCustomerNumber = relationsArray.getInt(i);

					Country cr = Country.find("byName", rCustomerNumber).first();

					if (null == cr)
						throw new DataFormatException("There is no country with name " + k, data);

					c.borders += (cr);
				}

			}
		}
	}
	
	*/
}
