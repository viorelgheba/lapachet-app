package emag.lapachet;

import emag.lapachet.api.ApiProducts;
import emag.lapachet.index.IndexController;
import emag.lapachet.service.SqlProducts;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

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

        try {

            get("/", (request, response) -> {
                Object attributes = IndexController.serveIndexPage();
                return new ModelAndView(attributes, "index.ftl");
            }, new FreeMarkerEngine());

            get("/", (request, response) -> {
                Object attributes = IndexController.serveIndexPage();
                return new ModelAndView(attributes, "index.ftl");
            }, new FreeMarkerEngine());

            get("/add_products", (request, response) -> {
                    Object attributes = IndexController.getAddProductsAttributes();
                    return new ModelAndView(attributes, "addProducts/form.ftl");
            }, new FreeMarkerEngine());

            post("/add_products", (request, response) -> {
                Object attributes = IndexController.serveIndexPage();
                return new ModelAndView(attributes, "index.ftl");
            }, new FreeMarkerEngine());

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("message", e.getMessage());

        }
    }
}
