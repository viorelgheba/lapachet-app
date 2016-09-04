package emag.lapachet.service;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import emag.lapachet.entity.Product;
import emag.lapachet.modelInterface.ProductInterface;
import emag.lapachet.repository.ProductRepository;
import emag.lapachet.util.Db;
import emag.lapachet.util.GenericList;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

public class SqlProduct implements ProductInterface
{
    private ProductRepository productRepository;

    public SqlProduct() {
        this.productRepository = new ProductRepository();
    }

    @Override
    public UUID addProduct(Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit) {
        return null;
    }

    @Override
    public UUID editProduct(UUID product, Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit) {
        return null;
    }

    @Override
    public UUID deleteProduct(UUID product) {
        return null;
    }

    @Override
    public Product getProduct(Integer productId) {
        return new Product();
    }

    @Override
    public List getAllProducts() {
        return (List) this.productRepository.getAllProducts();
    }

    public List<Document> getDailyMenus(String date)
    {
        List<Document> menus = new ArrayList<>();

        Document dailySale = Db.getMongoDatabase().getCollection("daily_sale").find(eq("date", date)).first();
        FindIterable<Document> iterable = Db.getMongoDatabase().getCollection("sale_item").find(and(eq("daily_sale_id", dailySale.get("_id")), eq("category_id", 14)));

        List<Object> productIds = new ArrayList<>();

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
                if (productIds.contains(document.get("product_id"))) {
                    productIds.add(document.get("product_id"));
                }
            }
        });

        iterable = Db.getMongoDatabase().getCollection("products").find(in("_id", productIds));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                menus.add(document);
            }
        });

        return menus;
    }
}
