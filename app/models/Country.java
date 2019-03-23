package models;

// This needs to print out population
// Print out bordering countries

//import java.util.Iterator;
import java.util.ArrayList;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.FileParser;


import javax.persistence.*;

import play.db.jpa.*;



@Entity
public class Country extends Area{
	//Country Class
	
	//Initialising variables
	private ArrayList<City> cities = new ArrayList<>();
	
	// Add a city to the city arrayList
	public void addCity(City c) {
		cities.add(c);
	}
	
	// prints all cities in arraylist
	public void getCities() {
		for(City c: this.cities) {
			System.out.println(c.getName());
		}
	}
	
	// Returns the whole array to user
	public ArrayList<City> giveArray(){
		return this.cities;
	}
	
	// Returns total population of country, based on cities
	@Override
	public long getPop() {
		long tot = 0;
		for(City c: cities) {
			tot += (c.getPop());
		}
		return tot;
	}
	
	// Gets capital of country
	public City getCapital() {
		City cap = null;
		for(City c: this.cities) {
			if(c.getCapital()) {
				cap = c;
			}
		
		}
		return cap;
	}
	
	
	
	
	// Looks for a city, given a name
	public City queryList(String q) {
		// Initialise city as null to return nothing if list doesn't exist
		City query = null;
		// Loops city list
		for(City c: this.cities) {
			// If the cities name is what the user is looking for, it returns the city class
			if(c.getName().equals(q)) {
				query = c;
			}
			
		}
		return query;
	}
	
	
	// Constructor 
	public Country(String name) {
		//Initialise Data
		setName(name);
		//Add the countries' cities from json file to arraylist
		
		// Adding cities to arraylist
		
		// A rather dirty solution, but my knowledge with JSON is limited
		// Please cut me a little slack, I'm learning as I'm coding here
		
		JSONArray country = (JSONArray) FileParser.dataSetter().get("countries");
		for(Object j: country) {
			// Cast j as a JSONObject
			JSONObject h = (JSONObject) j;
			// Get the name of the country h
			String r = (String) (h.get("name"));
			// Get the cities of the country h
			JSONArray cities = (JSONArray) h.get("cities");
			//System.out.println(cities);
			
			// If the country found is the one being init, then add cities to arraylist
			if(r.equals(name)) {
				for(Object n: cities) {
					// Casting n as a JSONObject
					JSONObject m = (JSONObject) n;
					// Getting the name of the city for city creation
					String cityName =(String) m.get("name");
					// Creating city 
					City city = new City(cityName);
					// Adding it to list
					addCity(city);
				}
				// Breaks out of constructor when finished, to stop any unnecessary calculation
				break;
			}
			
		}
		
			
	}
	

}
