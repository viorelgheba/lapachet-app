package emag.lapachet.modelInterface;

import emag.lapachet.util.GenericList;

import java.sql.Time;
import java.util.UUID;

public interface IntervalsInterface
{
    UUID addInterval(Time timeStart, Time timeEnd, Integer maxSales);
    UUID editInterval(UUID interval, Time timeStart, Time timeEnd, Integer maxSales);
    UUID deleteInterval(UUID interval);
    GenericList getAllIntervals();
}
