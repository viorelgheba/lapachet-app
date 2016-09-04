package emag.lapachet.index;

import emag.lapachet.entity.Category;
import emag.lapachet.entity.DailySale;
import emag.lapachet.entity.SaleInterval;
import emag.lapachet.repository.DailySaleRepository;
import emag.lapachet.repository.IntervalRepository;
import emag.lapachet.repository.SaleIntervalRepository;
import emag.lapachet.service.SqlCategory;
import emag.lapachet.service.SqlInterval;

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
}
