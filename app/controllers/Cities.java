package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@Check("admin")
@With(Secure.class)
@CRUD.For(City.class)
public class Cities extends CRUD {

}
