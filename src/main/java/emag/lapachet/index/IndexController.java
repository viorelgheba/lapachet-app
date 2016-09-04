package emag.lapachet.index;

import emag.lapachet.entity.Category;
import emag.lapachet.entity.DailySale;
import emag.lapachet.entity.SaleInterval;
import emag.lapachet.repository.DailySaleRepository;
import emag.lapachet.repository.IntervalRepository;
import emag.lapachet.repository.SaleIntervalRepository;
import emag.lapachet.service.SqlCategory;
import emag.lapachet.service.SqlInterval;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexController {
    public static Map<String, Object> serveIndexPage ()
    {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", "Hello World!");

        return attributes;
    }

    public static Map<String, Object> getAddProductsAttributes() {
        Map<String, Object> attributes = new HashMap<>();

        SqlCategory sqlCategories = new SqlCategory();
        List categories = sqlCategories.getAllCategories();
        attributes.put("categories", categories);

        return attributes;
    }

    public static Map<String, Object> getAddCategoriesAttributes() {
        Map<String, Object> attributes = new HashMap<>();

        SqlCategory sqlCategories = new SqlCategory();
        List categories = sqlCategories.getAllCategories();
        attributes.put("categories", categories);

        return attributes;
    }

    public static Map<String, Object> getIntervalAttributes() {
        Map<String, Object> attributes = new HashMap<>();

        DailySaleRepository dailySaleRepository = new DailySaleRepository();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        DailySale dailySale = dailySaleRepository.getCurrentDailySale(date);

        SaleIntervalRepository saleIntervalRepository = new SaleIntervalRepository();
        List<SaleInterval> saleIntervals = saleIntervalRepository.getCurrentSaleIntervals(dailySale);

        SqlInterval sqlInterval = new SqlInterval();
        List intervals = sqlInterval.getAllIntervals();
        attributes.put("intervals", intervals);

        return attributes;
    }

    public static void restoreDb() {
        Integer id = 0;

        // insert sale_items
        Db.getMongoDatabase().getCollection("sale_item").deleteMany(new Document());

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                    .append("price", 8)
                    .append("product_id", 56)
                    .append("daily_sale_id", 1)
                    .append("quantity", 5)
                    .append("category_id", 14)
        );

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                        .append("price", 8)
                        .append("product_id", 57)
                        .append("daily_sale_id", 1)
                        .append("quantity", 5)
                        .append("category_id", 14)
        );

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                        .append("price", 8)
                        .append("product_id", 58)
                        .append("daily_sale_id", 1)
                        .append("quantity", 5)
                        .append("category_id", 14)
        );

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                        .append("price", 8)
                        .append("product_id", 41)
                        .append("daily_sale_id", 1)
                        .append("quantity", 5)
                        .append("category_id", 11)
        );

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                        .append("price", 8)
                        .append("product_id", 42)
                        .append("daily_sale_id", 1)
                        .append("quantity", 5)
                        .append("category_id", 11)
        );

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                        .append("price", 8)
                        .append("product_id", 43)
                        .append("daily_sale_id", 1)
                        .append("quantity", 5)
                        .append("category_id", 11)
        );

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                        .append("price", 8)
                        .append("product_id", 50)
                        .append("daily_sale_id", 1)
                        .append("quantity", 5)
                        .append("category_id", 13)
        );

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                        .append("price", 8)
                        .append("product_id", 51)
                        .append("daily_sale_id", 1)
                        .append("quantity", 5)
                        .append("category_id", 13)
        );

        id++;
        Db.getMongoDatabase().getCollection("sale_item").insertOne(
                new Document().append("_id", id)
                        .append("price", 8)
                        .append("product_id", 52)
                        .append("daily_sale_id", 1)
                        .append("quantity", 5)
                        .append("category_id", 13)
        );

        // intervals
        for (Integer iId = 1; iId <= 14; iId++) {
            Db.getMongoDatabase().getCollection("interval").updateOne(
                    new Document("_id", iId),
                    new Document("$set", new Document("max_sales", 1))
            );
        }

        // sale_intervals
        Db.getMongoDatabase().getCollection("sale_interval").deleteMany(new Document());
        for (Integer siId = 1; siId <= 14; siId++) {
            Db.getMongoDatabase().getCollection("sale_interval").insertOne(
                    new Document().append("_id", siId)
                            .append("interval_id", siId)
                            .append("daily_sale_id", 1)
                            .append("clients", 0)
            );
        }
    }
}
