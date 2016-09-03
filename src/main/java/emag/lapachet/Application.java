package emag.lapachet;

import emag.lapachet.api.ApiProducts;
import emag.lapachet.index.IndexController;
import emag.lapachet.service.SqlProducts;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        new ApiProducts(new SqlProducts());

        get("/", (request, response) -> {

            Object attributes = IndexController.serveIndexPage();
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
    }
}
