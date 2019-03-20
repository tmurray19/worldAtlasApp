package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.FileParser;

public class City extends Area{
	
	//Variable Initialisation
	private boolean capital;
	
	// Find and set the population from the json list
	// Also defines city as being the capital if the clause holds
	public void cityBuilder() {
		
		// Creates country JSONArray
		
		/* 
		 * This could be done better. It's really inefficient to check through each object. It's pretty
		 * much O(n). Come back and fix this if you have the time.
		 */
		JSONArray country = (JSONArray) FileParser.dataSetter().get("countries");
		// Runs through JSON file looking for data it needs to
		for(Object j: country) {
			// Cast j as a JSONObject
			JSONObject h = (JSONObject) j;
			// Gets cities in each country
			JSONArray cities = (JSONArray) h.get("cities");
			// Gets the capital of the country
			long capital = (Long) h.get("capital");
			// For each city 
			for(Object n: cities) {
				JSONObject m = (JSONObject) n;
				// Gets name of city
				String cityName =(String) m.get("name");
				// If the city we're looking for is the same as the one in the file
				if(cityName.equals(getName())) {
					
					long pop = (Long) m.get("pop");
					long id = (Long) m.get("id");
					// Sets capital if needed
					if(id == capital) {
						setCapital();
					}
					// Sets population
					this.setPop(pop);
					// Finished code, as we don't need to run through the file anymore	
					break;
				}
			}
		}	
	}
		
	// Flags the country as a Capital
	public void setCapital() {
		this.capital = true;
	}

	// Returns capital status of City
	public boolean getCapital() {
		return this.capital;
	}

	public City(String s) {
		setName(s);
		cityBuilder();
	}
	
	
}
