package emag.lapachet.service;

import emag.lapachet.modelInterface.DailySaleInterface;
import emag.lapachet.repository.DailySaleRepository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class SqlDailySale implements DailySaleInterface
{
    private DailySaleRepository dailySaleRepository;

    public SqlDailySale() {
        this.dailySaleRepository = new DailySaleRepository();
    }

    @Override
    public UUID addDailySale(Date date) {
        return null;
    }

    @Override
    public UUID editDailySale(UUID dailySale, Date date) {
        return null;
    }

    @Override
    public UUID deleteDailySale(UUID dailySale) {
        return null;
    }

    @Override
    public List getAllDailySales() {
        return (List) this.dailySaleRepository.getAllDailySales();
    }
}
