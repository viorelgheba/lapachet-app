package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.DailySaleItem;
import emag.lapachet.util.Db;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class DailySaleItemRepository
{
    public Document getSaleItem(Integer productId, Object dailySaleId)
    {
        return Db.getMongoDatabase().getCollection("sale_item").find(and(eq("product_id", productId), eq("daily_sale_id", dailySaleId))).first();
    }

    public List<DailySaleItem> getAllSaleDailyItems() {
        List<DailySaleItem> dailySales = new ArrayList<>();

        MongoDatabase db = Db.getMongoDatabase();
        FindIterable<Document> iterable = db.getCollection("category").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                DailySaleItem dailySale = new DailySaleItem(
                        document.getInteger("_id"),
                        document.getDouble("price"),
                        document.getInteger("product_id"),
                        document.getInteger("daily_sale_id"),
                        document.getInteger("category_id"),
                        document.getDate("date"),
                        document.getInteger("quantity")
                );
                dailySales.add(dailySale);
            }
        });

        return dailySales;
    }
}
