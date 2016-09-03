package emag.lapachet.modelInterface;

import emag.lapachet.util.GenericList;

import java.sql.Date;
import java.util.UUID;

public interface DailySaleInterface
{
    UUID addDailySale(Date date);
    UUID editDailySale(UUID dailySale, Date date);
    UUID deleteDailySale(UUID dailySale);
    GenericList getAllDailySale();
}
