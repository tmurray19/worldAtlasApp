package models;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;

import play.data.validation.*;
 
@Entity
public class User extends Model {
 	
	@Required
	@MinSize(8)
	public String name;
	
	@Required
	@Email
	public String email;
	
	@Required
	@MaxSize(1000)
	public String address;
	
	public String toString() {
		return email;
	}
 	
}