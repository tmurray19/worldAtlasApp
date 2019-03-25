package models;
import java.util.ArrayList;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;


// An attempt at implementing polymorphism into the project
@Entity
public class Area extends Model{
	// Initialising variables
	// Has to be initialised as 0 here, so that values can be added correctly down the hirearchy
	private long population;
	private String name;
	
	// Set name
	public void setName(String n) {
		this.name = n;
	}
	
	// returns name
	public String getName() {
		return this.name;
	}
	
	// returns population
	public long getPopulation() {
		return this.population;
	}
	
	// sets population
	public void setPopulation(long population) {
		this.population = population;
		
	}
	
}
