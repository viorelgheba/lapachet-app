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
    private static Integer menuCategoryId = 14;
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
