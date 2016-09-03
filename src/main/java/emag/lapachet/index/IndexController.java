package emag.lapachet.index;

import java.util.HashMap;
import java.util.Map;

public class IndexController {
    public static Object serveIndexPage ()
    {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", "Hello World!");

        return attributes;
    }
}
