package emag.lapachet.service;

import emag.lapachet.entity.SaveSale;
import emag.lapachet.modelInterface.SaleInterface;
import emag.lapachet.util.Db;
import org.bson.Document;
import java.util.Date;

/**
 * Created by viorel.gheba on 9/4/16.
 */
public class SqlSale implements SaleInterface {
    @Override
    public Object addSale(SaveSale saveSale) {
        Date now = new Date();

        Document sale = new Document();
        sale.append("user_id", saveSale.userId)
                .append("sale_interval_id", saveSale.intervalId)
                .append("status", 1)
                .append("created", now)
                .append("modified", now);

        Db.getMongoDatabase().getCollection("sale").insertOne(sale);

        return sale.get("_id");
    }
}
