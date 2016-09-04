package emag.lapachet.service;

import emag.lapachet.modelInterface.CategoryInterface;
import emag.lapachet.repository.CategoryRepository;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import emag.lapachet.util.Db;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SqlCategory implements CategoryInterface
{
    private CategoryRepository categoryRepository;
    public SqlCategory() {
        this.categoryRepository = new CategoryRepository();
    }

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
    public List getAllCategories() {
        return (List) this.categoryRepository.getAllCategories();
    }

    /**
     * Returns daily categories
     * @param date string yyyy-mm-dd
     * @return
     */
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
