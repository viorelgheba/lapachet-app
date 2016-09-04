package emag.lapachet.repository;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import emag.lapachet.entity.Interval;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class IntervalRepository
{
    public List<Interval> getAllIntervals() {
        List<Interval> intervals = new ArrayList<>();

        MongoDatabase db = Db.getMongoDatabase();
        FindIterable<Document> iterable = db.getCollection("category").find();
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
}
