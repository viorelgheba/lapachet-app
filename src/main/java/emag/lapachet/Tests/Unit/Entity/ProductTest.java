package emag.lapachet.Tests.Unit.Entity;

import emag.lapachet.entity.Product;
import junit.framework.TestCase;

public class ProductTest extends TestCase{

    public void testGetters() {
        Product product = new Product(1, 1, "Product", "Description", 1.1, 1, "UM");

        assertTrue(1 == product.getId());
        assertTrue(1 == product.getCategoryId());
        assertEquals("Product", product.getName());
        assertEquals("Description", product.getDescription());
        assertTrue(1.1 == product.getBasePrice());
        assertTrue(1 == product.getGrammage());
        assertEquals("UM", product.getUnit());
    }

    public void testToString() {
        Product product = new Product(1, 1, "Product", "Description", 1.1, 1, "UM");
        String actual = product.toString();
        String expected = "ProductInterface{id=1, categoryId=1, name='Product', description='Description', basePrice=1.1, grammage=1, unit='UM'}";
    }
}
