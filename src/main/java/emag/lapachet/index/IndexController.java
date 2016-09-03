package emag.lapachet.index;

import emag.lapachet.entity.Products;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Map;

public class IndexController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        Products p = new Products(1, "categorie", "description", 12.23, 100, "gr");

        return "zzzzzzzz";
    };
}
