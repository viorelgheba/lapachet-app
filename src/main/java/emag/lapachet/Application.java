package emag.lapachet;

import emag.lapachet.index.IndexController;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {

        get("/", (request, response) -> {

            Object attributes = IndexController.serveIndexPage();
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
    }
}
