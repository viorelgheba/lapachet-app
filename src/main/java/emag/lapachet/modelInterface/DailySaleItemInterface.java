package emag.lapachet.modelInterface;

import emag.lapachet.service.GenericList;

import java.sql.Date;
import java.util.UUID;

public interface DailySaleItemInterface
{
    UUID addDailySaleItem(Float price, Integer productId, Integer dailySaleId, Date date, Integer quantity);
    UUID editDailySaleItem(UUID dailySaleItem, Float price, Integer productId, Integer dailySaleId, Date date, Integer quantity);
    UUID deleteDailySaleItem(UUID dailySaleItem);
    GenericList getAllDailySaleItem();
}
