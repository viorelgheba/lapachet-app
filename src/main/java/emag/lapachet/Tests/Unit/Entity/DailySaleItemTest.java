package emag.lapachet.Tests.Unit.Entity;

import emag.lapachet.entity.DailySaleItem;
import junit.framework.*;

import java.util.Date;

public class DailySaleItemTest extends TestCase{

    public void testGetters() {
        DailySaleItem dailySaleItem = new DailySaleItem(1, 1.1, 1, 1, 1, new Date(2016, 1, 1), 1);

        assertTrue(dailySaleItem.getId() == 1);
        assertTrue(dailySaleItem.getPrice() == 1.1);
        assertTrue(dailySaleItem.getProductId() == 1);
        assertTrue(dailySaleItem.getDailySaleId() == 1);
        assertTrue(dailySaleItem.getCategoryId() == 1);
        assertEquals(new Date(2016, 1, 1), dailySaleItem.getDate());
        assertTrue(dailySaleItem.getQuantity() == 1);
    }

    public void testToString() {
        DailySaleItem dailySaleItem = new DailySaleItem(1, 1.1, 1, 1, 1, new Date(2016, 1, 1), 1);
        String actual = dailySaleItem.toString();
        String expected = "DailySaleItemInterface{id=1, price=1.1, productId=1, dailySaleId=1, date=Tue Feb 01 00:00:00 EET 3916, quantity=1}";
    }
}
