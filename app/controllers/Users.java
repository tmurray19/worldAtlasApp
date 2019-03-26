package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
//List of Users
@Check("admin")
@With(Secure.class)
public class Users extends CRUD {

}
