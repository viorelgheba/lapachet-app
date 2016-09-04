package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.Product;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class ProductRepository
{
    public static Integer menuCategoryId = 14;

    public Document getProduct(Integer productId)
    {
        return Db.getMongoDatabase().getCollection("product").find(eq("_id", productId)).first();
    }

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

    public List<Document> getCategoryProducts(String date)
    {
        return this.getCategoryProducts(date, menuCategoryId);
    }

    public List<Document> getCategoryProducts(String date, Integer categoryId)
    {
        List<Document> menus = new ArrayList<>();

        Document dailySale = Db.getMongoDatabase().getCollection("daily_sale").find(eq("date", date)).first();
        Integer dailySaleId = dailySale.getInteger("_id");

        FindIterable<Document> iterable = Db.getMongoDatabase().getCollection("sale_item").find(and(eq("daily_sale_id", dailySaleId), eq("category_id", categoryId)));

        List<Object> productIds = new ArrayList<>();

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document saleItem) {
                Object productId = saleItem.get("product_id");
                if (!productIds.contains(productId)) {
                    Document product = Db.getMongoDatabase().getCollection("product").find(eq("_id", saleItem.get("product_id"))).first();
                    menus.add(product);
                    productIds.add(productId);
                }
            }
        });

        return menus;
    }
}
