package controllers;

import models.User;
import play.*;
import play.mvc.*;
import play.libs.Json;
import views.html.*;
import play.data.Form;
import play.db.ebean.Model;
import java.util.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Sample PlayFramework 2.3 Java Application"));
    }

    public static Result addUser() {
    	User newUser = Form.form(User.class).bindFromRequest().get();
    	newUser.save();
    	return redirect(routes.Application.index());
    }
    
    public static Result listUsers() {
    	List<User> users = new Model.Finder(String.class, User.class).all();
    	return ok(Json.toJson(users));
    }

}
