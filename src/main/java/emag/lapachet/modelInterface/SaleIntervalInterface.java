package emag.lapachet.modelInterface;

import emag.lapachet.service.GenericList;

import java.util.UUID;

public interface SaleIntervalInterface
{
    UUID addSaleInterval(Integer intervalId, Integer dailySaleId, Integer clients);
    UUID editSaleInterval(UUID SaleInterval, Integer intervalId, Integer dailySaleId, Integer clients);
    UUID deleteSaleInterval(UUID SaleInterval);
    GenericList getAllSaleInterval();
}
