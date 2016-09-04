package emag.lapachet;

import emag.lapachet.route.*;
import spark.Service;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        staticFiles.location("/public");
        Service http = Service.ignite().port(Integer.valueOf(System.getenv("PORT")));

        RouteContext routeContext = new RouteContext(http);
        routeContext.addEndpoint(new HomeEndpoint());
        routeContext.addEndpoint(new CategoryApiEndpoint());
        routeContext.addEndpoint(new ProductApiEndpoint());
        routeContext.addEndpoint(new IntervalApiEndpoint());
    }
}
