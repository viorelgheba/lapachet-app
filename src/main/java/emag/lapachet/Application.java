package emag.lapachet;

import emag.lapachet.api.ApiProducts;
import emag.lapachet.index.IndexController;
import emag.lapachet.service.SqlProducts;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

public class Application {

//    private static final Integer PORT;
//
//    static {
//        PORT = Integer.valueOf(System.getenv("PORT"));
//    }

    public static void main(String[] args) {
        // port(PORT);
        staticFileLocation("/public");

        new ApiProducts(new SqlProducts());

        get("/", (request, response) -> {
            Object attributes = IndexController.serveIndexPage();
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
    }
}
