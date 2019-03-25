// User model
package models;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;

import play.data.validation.*;
 
@Entity
public class User extends Model {
 	
	//@Required
	public String name;
	
	//@Required
	public String email;
	
	//@Required
	public String password;
	
	public boolean isAdmin;
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
    public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }
    
    public String toString() {
    	return name;
    }
}