package emag.lapachet.api;

import emag.lapachet.service.GenericList;
import emag.lapachet.service.SqlProducts;

import static spark.Spark.*;

public class ApiController
{
    public static void main(String[] args) {
        get("/", (request, response) -> {
            SqlProducts sqlProduct = new SqlProducts();
            GenericList products = sqlProduct.getAllProducts();

            return products;
        });
    }
}
