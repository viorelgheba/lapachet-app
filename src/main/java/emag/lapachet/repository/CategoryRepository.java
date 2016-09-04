package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.Category;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

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

    public List<Document> getDailyCategories(String date)
    {
        List<Document> categories = new ArrayList<>();

        Document dailySale = Db.getMongoDatabase()
                .getCollection("daily_sale")
                .find(eq("date", date))
                .first();
        Integer dailySaleId = Integer.parseInt(dailySale.get("_id").toString());

        FindIterable<Document> iterable = Db.getMongoDatabase().getCollection("sale_item").find(eq("daily_sale_id", dailySaleId));

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document saleItem) {
                Document product = Db.getMongoDatabase().getCollection("product").find(eq("_id", saleItem.getInteger("product_id"))).first();
                Document category = Db.getMongoDatabase().getCollection("category").find(eq("_id", product.getInteger("category_id"))).first();
                if (!categories.contains(category)) {
                    categories.add(category);
                }
            }
        });

        return categories;
    }
}
