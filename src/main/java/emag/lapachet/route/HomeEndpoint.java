package emag.lapachet.route;

import emag.lapachet.index.IndexController;
import spark.ModelAndView;
import spark.Service;
import spark.template.freemarker.FreeMarkerEngine;

public class HomeEndpoint extends AbstractEndpoint {
    public HomeEndpoint(String basePath) {
        super(basePath);
    }

    @Override
    public void configure(Service spark) {
        spark.get(basePath + "/", (req, res) -> {
            Object attributes = IndexController.serveIndexPage();
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
    }
}
