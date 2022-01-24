import static spark.Spark.*;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        get("/login", (request, response) -> {
            return new ModelAndView(new HashMap(), "login.hbs");
        }, new HandlebarsTemplateEngine());
        get("/signup", (request, response) -> {
            return new ModelAndView(new HashMap(), "signup.hbs");
        }, new HandlebarsTemplateEngine());
        get("/homepage", (request, response) -> {
            return new ModelAndView(new HashMap(), "homepage.hbs");
        }, new HandlebarsTemplateEngine());
        get("/welcome", (request, response) -> {
            return new ModelAndView(new HashMap(), "welcome.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
