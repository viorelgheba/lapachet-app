package emag.lapachet.modelInterface;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

public interface IntervalInterface
{
    UUID addInterval(Time timeStart, Time timeEnd, Integer maxSales);
    UUID editInterval(UUID interval, Time timeStart, Time timeEnd, Integer maxSales);
    UUID deleteInterval(UUID interval);
    List getAllIntervals();
}
