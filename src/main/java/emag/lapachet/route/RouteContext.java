package emag.lapachet.route;

import spark.Service;

public class RouteContext {

    private final Service spark;

    /**
     * @param spark
     */
    public RouteContext(Service spark) {
        this.spark = spark;
    }

    /**
     * @param endpoint
     */
    public void addEndpoint(EndpointInterface endpoint) {
        endpoint.configure(this.spark);
    }
}
