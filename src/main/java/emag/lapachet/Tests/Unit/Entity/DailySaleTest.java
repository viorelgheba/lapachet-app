package emag.lapachet.Tests.Unit.Entity;

import emag.lapachet.entity.DailySale;
import junit.framework.*;

import java.util.Date;

public class DailySaleTest extends TestCase {

    public void testGetters() {
        DailySale dailySale = new DailySale(1, new Date(2016, 8, 4));

        assertTrue(dailySale.getId() == 1);
        assertEquals(new Date(2016, 8, 4), dailySale.getDate());
    }

    public void testSetters() {
        DailySale expectedDailySale = new DailySale(1, new Date(2016, 8, 4));
        DailySale dailySale = new DailySale(2, new Date(2016, 1, 1));

        dailySale.setId(1);
        dailySale.setDate(new Date(2016, 8, 4));

        assertEquals(expectedDailySale.getId(), dailySale.getId());
        assertEquals(expectedDailySale.getDate(), dailySale.getDate());
    }

    public void testToString() {
        DailySale dailySale = new DailySale(1, new Date(2016, 8, 4));
        String actual = dailySale.toString();
        String expected = "DailySaleInterface{id=1, date=Mon Sep 04 00:00:00 EEST 3916}";

        assertEquals(expected, actual);
    }
}
