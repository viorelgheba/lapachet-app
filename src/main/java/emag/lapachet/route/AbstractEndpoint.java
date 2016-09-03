package emag.lapachet.route;

abstract class AbstractEndpoint implements EndpointInterface {
    protected final String basePath;

    public AbstractEndpoint(String basePath) {
        this.basePath = basePath;
    }
}
