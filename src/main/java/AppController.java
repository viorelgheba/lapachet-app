import static spark.Spark.*;

public class AppController {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
