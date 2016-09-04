package emag.lapachet.service;

import emag.lapachet.modelInterface.SaleIntervalInterface;
import emag.lapachet.repository.SaleIntervalRepository;

import java.util.List;
import java.util.UUID;

public class SqlSaleInterval implements SaleIntervalInterface
{
    private SaleIntervalRepository saleIntervalRepository;
    @Override
    public UUID addSaleInterval(Integer intervalId, Integer dailySaleId, Integer clients) {
        return null;
    }

    @Override
    public UUID editSaleInterval(UUID SaleInterval, Integer intervalId, Integer dailySaleId, Integer clients) {
        return null;
    }

    @Override
    public UUID deleteSaleInterval(UUID SaleInterval) {
        return null;
    }

    @Override
    public List getAllSaleInterval() {
        return (List) this.saleIntervalRepository.getAllSaleIntervals();
    }
}
