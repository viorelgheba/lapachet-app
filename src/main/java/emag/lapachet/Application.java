package emag.lapachet;

import emag.lapachet.index.IndexController;
import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        get("/", IndexController.serveIndexPage);
    }
}
