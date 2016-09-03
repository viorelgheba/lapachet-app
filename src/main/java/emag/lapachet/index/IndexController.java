package emag.lapachet.index;

import emag.lapachet.entity.Category;
import emag.lapachet.service.SqlCategories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexController {
    public static Map<String, Object> serveIndexPage ()
    {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", "Hello World!");

        return attributes;
    }

    public static Map<String, Object> getAddProductsAttributes() throws ClassNotFoundException {
        Map<String, Object> attributes = new HashMap<>();

        SqlCategories sqlCategories = new SqlCategories();
        List<Category> categories = sqlCategories.getAllCategories();
        attributes.put("categories", categories);

        return attributes;
    }
}
