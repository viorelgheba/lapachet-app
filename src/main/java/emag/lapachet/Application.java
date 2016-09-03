package emag.lapachet;

import emag.lapachet.route.HomeEndpoint;
import emag.lapachet.route.ProductApiEndpoint;
import emag.lapachet.route.RouteContext;
import spark.Service;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        staticFiles.location("/public");
        Service http = Service.ignite();//.port(5000);

        RouteContext routeContext = new RouteContext(http);
        routeContext.addEndpoint(new HomeEndpoint(""));
        routeContext.addEndpoint(new ProductApiEndpoint("/api/products"));
    }
}
