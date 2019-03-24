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
	private ArrayList<String> cities = new ArrayList<>();
	private ArrayList<String> bordering = new ArrayList<>();
	private String capital;
	
	// Add a city to the city arrayList
	public void setCities(ArrayList<String> cities) {
		this.cities = cities;
	}

	// Returns the whole array to user
	public ArrayList<String> getCities(){
		return this.cities;
	}
	
	public void setBorders(ArrayList<String> bordering) {
		this.bordering = bordering;
	}

	public ArrayList<String> getBorders(){
		return this.bordering;
	}
	
	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	// Constructor 
	public Country(String name, long p, ArrayList<String> cities, ArrayList<String> bordering) {
		//Initialise Data
		setName(name);
		setPop(p);
		setCities(cities);
		setBorders(bordering);
	}
	

}
