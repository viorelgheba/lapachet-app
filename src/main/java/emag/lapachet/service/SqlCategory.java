package emag.lapachet.service;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.Category;
import emag.lapachet.modelInterface.CategoryInterface;
import emag.lapachet.util.Db;
import emag.lapachet.util.GenericList;
import org.bson.Document;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SqlCategory implements CategoryInterface
{
    public UUID addCategory(Integer parent, String name) {
        return null;
    }

    @Override
    public UUID editCategory(UUID category, Integer parent, String name) {
        return null;
    }

    @Override
    public UUID deleteCategory(UUID product) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        FindIterable<Document> iterable = Db.getMongoDatabase().getCollection("category").find();
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
