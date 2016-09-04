package emag.lapachet.route;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import emag.lapachet.entity.Category;
import emag.lapachet.entity.Product;
import emag.lapachet.index.IndexController;
import spark.ModelAndView;
import spark.Service;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;

public class HomeEndpoint implements EndpointInterface {
    @Override
    public void configure(Service spark) {
        spark.get("/", (req, res) -> {
            Object attributes = IndexController.serveIndexPage();
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        spark.get("/add_products", (request, response) -> {
            Object attributes = IndexController.getAddProductsAttributes();
            return new ModelAndView(attributes, "addProducts/form.ftl");
        }, new FreeMarkerEngine());

        spark.post("/add_products", (request, response) -> {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(request.body()).getAsJsonObject();

            Product product = new Gson().fromJson(object.get("data"), Product.class);
            /* TODO save product */
            return true;
        });

        spark.get("/add_category", (request, response) -> {
            Object attributes = IndexController.getAddCategoriesAttributes();
            return new ModelAndView(attributes, "addCategories/form.ftl");
        }, new FreeMarkerEngine());

        spark.post("/add_category", (request, response) -> {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(request.body()).getAsJsonObject();

            Category category = new Gson().fromJson(object.get("data"), Category.class);
            /* TODO save category */
            return true;
        });

        spark.get("/add_daily_menu", (request, response) -> {
            return "Hello world";
        });

        spark.get("/intervals", (request, response) -> {
            Map<String, Object> attributes = IndexController.getIntervalAttributes();
            return "Hello world";
        });
    }
}
