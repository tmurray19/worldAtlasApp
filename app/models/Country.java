package models;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.FileParser;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;


// I couldn't produce the same Country class as last assignment
// JPA doesn't allow for editing of ArrayList in it's CRUD module
// I instead opt to store the borders and cities in a string
// Then split that string up where necessary
@Entity
public class Country extends Area{
	//Country Class

	//Initialising variables
    private String cities;
    private String capital;
    private String borders;

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getBorders() {
		return borders;
	}

	public void setBorders(String borders) {
		this.borders = borders;
	}

	public String toString() {
		return this.getName();
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}


	// Constructor
	public Country(String name, int population, String bordering, String capital, String cities) {
		//Initialise Data
		setBorders(bordering);
		setName(name);
		setCapital(capital);
		setPopulation(population);
		setCities(cities);
	}


    
}
