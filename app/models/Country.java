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
public class Country extends Model{
	//Country Class

	//Initialising variables
	private String name;
    private ArrayList<String> cities;
    private String capital;
    private ArrayList<String> borders;
    private long population;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Add a city to the city arrayList
	public void setCities(ArrayList<String> cities) {
		this.cities = cities;
	}

	// Returns the whole array to user
	public ArrayList<String> getCities(){
		return this.cities;
	}

	public void setBorders(ArrayList<String> bordering) {
		this.borders = bordering;
	}

	public ArrayList<String> getBorders(){
		return this.borders;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	// returns population
	public long getPop() {
		return this.population;
	}

	// sets population
	public void setPop(long p) {
		this.population = p;
	}

	// Constructor
	public Country(String name, long p, ArrayList<String> bordering, String capital, ArrayList<String> cities) {
		//Initialise Data
		setBorders(bordering);
		setName(name);
		setCapital(capital);
		setPop(p);
		setCities(cities);
	}


}
