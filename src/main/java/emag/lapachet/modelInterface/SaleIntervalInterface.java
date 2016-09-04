package emag.lapachet.modelInterface;

import java.util.List;
import java.util.UUID;

public interface SaleIntervalInterface
{
    UUID addSaleInterval(Integer intervalId, Integer dailySaleId, Integer clients);
    UUID editSaleInterval(UUID SaleInterval, Integer intervalId, Integer dailySaleId, Integer clients);
    UUID deleteSaleInterval(UUID SaleInterval);
    List getAllSaleInterval();
}
