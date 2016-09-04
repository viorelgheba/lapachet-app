package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.Product;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository
{
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        MongoDatabase db = Db.getMongoDatabase();
        FindIterable<Document> iterable = db.getCollection("category").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                Product product = new Product(
                        document.getInteger("_id"),
                        document.getInteger("parent_id"),
                        document.getString("name"),
                        document.getString("description"),
                        document.getDouble("base_price"),
                        document.getInteger("grammage"),
                        document.getString("unit")
                );
                products.add(product);
            }
        });

        return products;
    }
}
