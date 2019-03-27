package models;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;


// I couldn't produce the same Country class as last assignment
// JPA doesn't allow for editing of ArrayList in it's CRUD module
// I instead opt to store the borders and cities in a string
// Then split that string up where necessary
@Entity
public class Region extends Model{
	//Country Class

	//Initialising variables
	public String name;
	@ManyToMany
    public Set<City> cities;
	public City capital;
	public long population;
	@ManyToMany
    public Set<Region> borderState;
    
    

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}



	public City getCapital() {
		return capital;
	}



	public void setCapital(City capital) {
		this.capital = capital;
	}



	public Set<Region> getBorders() {
		return borderState;
	}



	public void setBorders(Set<Region> borders) {
		this.borderState = borders;
	}
    


	//public String toString() {
	//	return this.getName();
	//}



	// Constructor
	public Region(String name, int population, Set<Region> bordering, City capital, Set<City> cities) {
		//Initialise Data
		setBorders(bordering);
	//	setName(name);
		setCapital(capital);
	//	setPopulation(population);
		setCities(cities);
	}


    
}
