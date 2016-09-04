package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.Category;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository
{
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        MongoDatabase db = Db.getMongoDatabase();
        FindIterable<Document> iterable = db.getCollection("category").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                Category category = new Category(
                        document.getInteger("_id"),
                        document.getInteger("parent_id"),
                        document.getString("name"),
                        document.getInteger("status")
                );
                categories.add(category);
            }
        });

        return categories;
    }
}
