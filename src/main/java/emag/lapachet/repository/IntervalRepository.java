package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.Interval;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.lt;

public class IntervalRepository
{
    public List<Interval> getAllIntervals() {
        List<Interval> intervals = new ArrayList<>();

        MongoDatabase db = Db.getMongoDatabase();
        FindIterable<Document> iterable = db.getCollection("interval").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                Interval interval = new Interval(
                        document.getInteger("_id"),
                        Time.valueOf(document.getString("time_start")),
                        Time.valueOf(document.getString("time_end")),
                        document.getInteger("max_sales")
                );
                intervals.add(interval);
            }
        });

        return intervals;
    }

    public List<Document> getAvailableIntervals(String date)
    {
        List<Document> intervals = new ArrayList<>();

        Document dailySale = Db.getMongoDatabase().getCollection("daily_sale").find(eq("date", date)).first();
        Integer dailySaleId = dailySale.getInteger("_id");

        FindIterable<Document> iterable = Db.getMongoDatabase().getCollection("sale_interval").find(eq("daily_sale_id", dailySaleId));

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document saleInterval) {
                Date now = new Date();
                Document interval = Db.getMongoDatabase().getCollection("interval").find(eq("_id", saleInterval.get("daily_sale_id"))).first();

                if (interval != null) {
                    String[] parts = interval.getString("time_start").split(":");
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(parts[0]));
                    cal.set(Calendar.MINUTE, Integer.valueOf(parts[1]));
                    cal.set(Calendar.SECOND, Integer.valueOf(parts[2]));
                    Date start = cal.getTime();

                    if (saleInterval.getInteger("clients") < interval.getInteger("max_sales") && now.before(start)) {
                        Document doc = new Document();
                        doc.append("id", saleInterval.get("_id"))
                                .append("time_start", interval.get("time_start"))
                                .append("time_end", interval.get("time_end"));
                        intervals.add(doc);
                    }
                }
            }
        });

        return intervals;
    }
}
