package emag.lapachet.service;

import emag.lapachet.entity.SaveSale;
import emag.lapachet.modelInterface.SaleInterface;
import emag.lapachet.repository.DailySaleItemRepository;
import emag.lapachet.repository.ProductRepository;
import emag.lapachet.repository.SaleIntervalRepository;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Arrays.asList;

/**
 * Created by viorel.gheba on 9/4/16.
 */
public class SqlSale implements SaleInterface {

    private ProductRepository productRepository;
    private DailySaleItemRepository dailySaleItemRepository;
    private SaleIntervalRepository saleIntervalRepository;

    public SqlSale() {
        productRepository = new ProductRepository();
        dailySaleItemRepository = new DailySaleItemRepository();
        saleIntervalRepository = new SaleIntervalRepository();
    }

    @Override
    public Object addSale(SaveSale saveSale) {
        Date now = new Date();

        Document dailySale = Db.getMongoDatabase().getCollection("daily_sale").find(eq("date", saveSale.date)).first();
        Integer dailySaleId = dailySale.getInteger("_id");

        Document product = productRepository.getProduct(saveSale.productId);
        Document saleItem = dailySaleItemRepository.getSaleItem(saveSale.productId, dailySaleId);
        Document saleInterval = saleIntervalRepository.getSaleInterval(saveSale.intervalId);

        Document saleProduct = new Document();
        saleProduct.append("product_id", product.get("_id"))
                .append("sale_item_id", saleItem.get("_id"))
                .append("price", saleItem.get("price"))
                .append("quantity", 1);

        List<Document> saleProducts = new ArrayList<>();
        saleProducts.add(saleProduct);

        Document sale = new Document();
        sale.append("user_id", saveSale.userId)
                .append("sale_interval_id", saveSale.intervalId)
                .append("status", 1)
                .append("created", now)
                .append("modified", now)
                .append("products", saleProducts);

        Db.getMongoDatabase().getCollection("sale").insertOne(sale);

        // update sale item quantity
        Db.getMongoDatabase().getCollection("sale_item").updateOne(
                new Document("_id", saleItem.get("_id")),
                new Document("$inc", new Document("quantity", -1))
        );

        // update sale item quantity
        Db.getMongoDatabase().getCollection("sale_interval").updateOne(
                new Document("_id", saleInterval.get("_id")),
                new Document("$inc", new Document("clients", 1))
        );

        return sale.get("_id");
    }
}
