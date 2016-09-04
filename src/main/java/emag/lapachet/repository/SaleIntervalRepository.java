package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.DailySale;
import emag.lapachet.entity.SaleInterval;
import emag.lapachet.util.Db;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import static com.mongodb.client.model.Filters.eq;

public class SaleIntervalRepository
{
    public Document getSaleInterval(Integer id) {
        return Db.getMongoDatabase().getCollection("sale_interval").find(eq("_id", id)).first();
    }

    public Document getSaleInterval(Integer intervalId, Object dailySaleId) {
        return Db.getMongoDatabase().getCollection("sale_interval").find(and(eq("interval_id", intervalId), eq("daily_sale_id", dailySaleId))).first();
    }

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

    public List<SaleInterval> getCurrentSaleIntervals(DailySale dailySale) {
        List<SaleInterval> saleIntervals = new ArrayList<>();

        FindIterable<Document> iterable = Db.getMongoDatabase().getCollection("sale_interval").find(eq("interval_id", dailySale.getId()));
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
