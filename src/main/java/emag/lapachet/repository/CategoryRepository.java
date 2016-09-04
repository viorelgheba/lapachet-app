package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.Category;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository
{
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://viorel:parolaviorel@ds017776.mlab.com:17776/heroku_2ktc1zmv"));
        MongoDatabase db = mongoClient.getDatabase("heroku_2ktc1zmv");
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
