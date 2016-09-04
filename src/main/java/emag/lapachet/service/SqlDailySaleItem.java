package emag.lapachet.service;

import emag.lapachet.modelInterface.DailySaleItemInterface;
import emag.lapachet.repository.DailySaleItemRepository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class SqlDailySaleItem implements DailySaleItemInterface
{
    private DailySaleItemRepository dailySaleItemRepository;

    public SqlDailySaleItem(DailySaleItemRepository dailySaleItemRepository) {
        this.dailySaleItemRepository = dailySaleItemRepository;
    }

    @Override
    public UUID addDailySaleItem(Float price, Integer productId, Integer dailySaleId, Date date, Integer quantity) {
        return null;
    }

    @Override
    public UUID editDailySaleItem(UUID dailySaleItem, Float price, Integer productId, Integer dailySaleId, Date date, Integer quantity) {
        return null;
    }

    @Override
    public UUID deleteDailySaleItem(UUID dailySaleItem) {
        return null;
    }

    @Override
    public List getAllDailySaleItems() {
        return (List) this.dailySaleItemRepository.getAllSaleDailyItems();
    }
}
