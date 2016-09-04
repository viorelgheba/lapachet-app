package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.DailySale;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DailySaleRepository
{
    public List<DailySale> getAllDailySales() {
        List<DailySale> dailySales = new ArrayList<>();

        MongoDatabase db = Db.getMongoDatabase();
        FindIterable<Document> iterable = db.getCollection("daily_sale").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                DailySale dailySale = new DailySale(
                        document.getInteger("_id"),
                        document.getDate("date")
                );
                dailySales.add(dailySale);
            }
        });

        return dailySales;
    }

    public DailySale getCurrentDailySale(String currentDate) {
        DailySale dailySale = new DailySale();

        FindIterable<Document> iterable = Db.getMongoDatabase().getCollection("daily_sale").find(eq("date", currentDate));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                DailySale dailySale = new DailySale(
                        document.getInteger("_id"),
                        document.getDate("date")
                );
            }
        });

        return dailySale;
    }
}
