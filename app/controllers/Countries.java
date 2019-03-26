package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
// List of countries
@Check("admin")
@With(Secure.class)
@CRUD.For(Country.class)
public class Countries extends CRUD {

}
