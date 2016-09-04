package emag.lapachet.Tests.Unit.Entity;

import emag.lapachet.entity.Interval;
import junit.framework.*;

import java.sql.Time;

public class IntervalTest extends TestCase {

    public void testGetters() {
        Interval interval = new Interval(1, new Time(12, 0, 0), new Time(13, 0, 0), 100);

        assertTrue(interval.getId() == 1);
        assertEquals(new Time(12, 0, 0), interval.getTimeStart());
        assertEquals(new Time(13, 0, 0), interval.getTimeEnd());
        assertTrue(interval.getMaxSales() == 100);
    }

    public void testToString() {
        Interval interval = new Interval(1, new Time(12, 0, 0), new Time(13, 0, 0), 100);
        String actual = interval.toString();
        String expected = "IntervalInterface{id=1, timeStart=12:00:00, timeEnd=13:00:00, maxSales=100}";

        assertEquals(expected, actual);
    }
}
