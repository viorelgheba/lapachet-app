package emag.lapachet.route;

abstract class AbstractEndpoint implements EndpointInterface {
    final String basePath;

    AbstractEndpoint(String basePath) {
        this.basePath = basePath;
    }
}
