package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.FileParser;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class City extends Area{
	
	@ManyToOne
	public Country host;
	
	public boolean isCapital;

	public City(Country host, String name) {
		setHost(host);
		setName(name);
	}
	 
	public String toString() {
		return this.getName();
	}

	public Country getHost() {
		return host;
	}

	public void setHost(Country host) {
		this.host = host;
	}

	


}
