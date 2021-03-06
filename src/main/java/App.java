import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        get("/login", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
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
    }


}
