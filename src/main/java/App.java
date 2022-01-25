import static spark.Spark.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import AccessObjects.NewsDao;
import AccessObjects.UsersDao;
import Models.Users;
import com.google.gson.Gson;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        staticFileLocation("/public");
        port(getHerokuAssignedPort());
        Connection conn;
        NewsDao newsDao;
        Gson gson = new Gson();
        Sql2o sql2o= new Sql2o("jdbc:postgresql://njanrafgnesvze:493914d3d2397f8a063dfed294d9e5b35c516be4a05386f2fde0a7a21bbda15c@ec2-54-81-126-150.compute-1.amazonaws.com:5432/d94a2hc3amh737");

        //

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        get("/login", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String username= request.queryParams("username");
            UsersDao usersDao=new UsersDao();
//            usersDao.findById(username);
            System.out.println();
            return new ModelAndView(new HashMap(), "login.hbs");
        }, new HandlebarsTemplateEngine());
        get("/signup", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(new HashMap(), "signup.hbs");
        }, new HandlebarsTemplateEngine());
        get("/homepage", (request, response) -> {
            return new ModelAndView(new HashMap(), "homepage.hbs");
        }, new HandlebarsTemplateEngine());
        get("/welcome", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String username=request.queryParams("username");
            String passwordInput=request.queryParams("password");
            model.put("username",username);
            model.put("password",passwordInput);
            System.out.println("username ="+username+" password"+passwordInput);
            return new ModelAndView(model, "landingpage.hbs");
        }, new HandlebarsTemplateEngine());
        post("/newuser", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String username=request.queryParams("username");
            String email=request.queryParams("email");
            String password=request.queryParams("password");
            Users user=new Users(username,email,password);
            UsersDao usersDao=new UsersDao();
            usersDao.add(user);
            System.out.println("username ="+username+" password"+password);
            return new ModelAndView(model, "landingpage.hbs");
        }, new HandlebarsTemplateEngine());
    }


}
