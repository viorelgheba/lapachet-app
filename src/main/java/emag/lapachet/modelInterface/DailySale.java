package emag.lapachet.modelInterface;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface DailySale
{
    UUID addDailySale(Date date);
    UUID editDailySale(UUID dailySale, Date date);
    UUID deleteDailySale(UUID dailySale);
    List getAllDailySale();
}
