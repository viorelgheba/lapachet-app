package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.SaleInterval;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class SaleIntervalRepository
{
    public List<SaleInterval> getAllSaleIntervals() {
        List<SaleInterval> saleIntervals = new ArrayList<>();

        MongoDatabase db = Db.getMongoDatabase();
        FindIterable<Document> iterable = db.getCollection("category").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                SaleInterval saleInterval = new SaleInterval(
                        document.getInteger("_id"),
                        document.getInteger("interval_id"),
                        document.getInteger("daily_sale_id"),
                        document.getInteger("clients")
                );
                saleIntervals.add(saleInterval);
            }
        });

        return saleIntervals;
    }
}
