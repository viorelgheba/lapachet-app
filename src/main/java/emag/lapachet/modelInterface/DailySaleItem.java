package emag.lapachet.modelInterface;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface DailySaleItem
{
    UUID addDailySaleItem(Float price, Integer productId, Integer dailySaleId, Date date, Integer quantity);
    UUID editDailySaleItem(UUID dailySaleItem, Float price, Integer productId, Integer dailySaleId, Date date, Integer quantity);
    UUID deleteDailySaleItem(UUID dailySaleItem);
    List getAllDailySaleItem();
}
