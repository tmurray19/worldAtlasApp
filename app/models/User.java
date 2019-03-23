package models;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;

import play.data.validation.*;
 
@Entity
public class User extends Model {
 	
	//@Required
	//@MinSize(8)
	public String name;
	
	//@Required
	//@Email
	public String email;
	
	//@Required
	//@MaxSize(1000)
	public String address;
	
	public User(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}