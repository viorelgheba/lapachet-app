package emag.lapachet.route;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import emag.lapachet.entity.SaveSale;
import emag.lapachet.service.SqlSale;
import spark.Service;

public class SaleApiEndpoint implements EndpointInterface {

    public static final Gson GSON;

    static {
        GSON = new Gson();
    }

    private SqlSale sqlSale;

    public SaleApiEndpoint() {
        sqlSale = new SqlSale();
    }

    @Override
    public void configure(Service spark) {
        spark.post("/api/sales", "application/json", (req, res) -> {
            SaveSale saveSale = GSON.fromJson(req.body(), SaveSale.class);
            return sqlSale.addSale(saveSale);
        });
    }
}
