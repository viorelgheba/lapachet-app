package emag.lapachet.Tests.Unit.Entity;

import junit.framework.*;
import emag.lapachet.entity.Category;

public class CategoryTest extends TestCase{

    public void testGetters() {
        Category category = new Category(1, 1, "Test Category", 1);

        assertTrue(category.getId() == 1);
        assertTrue(category.getParentId() == 1);
        assertEquals(category.getName(), "Test Category");
        assertTrue(category.getStatus() == 1);
    }

    public void testSetters() {
        Category categoryExpected = new Category(1, 1, "Test Category", 1);
        Category category = new Category(2, 2, "Test Category2", 2);

        category.setId(1);
        category.setParentId(1);
        category.setName("Test Category");
        category.setStatus(1);

        assertEquals(category.getId(), categoryExpected.getId());
        assertEquals(category.getParentId(), categoryExpected.getParentId());
        assertEquals(category.getName(), categoryExpected.getName());
        assertEquals(category.getStatus(), categoryExpected.getStatus());
    }

    public void testToString() {
        Category category = new Category(1, 1, "Test Category", 1);
        String actual = category.toString();
        String expected = "Category{id=1, parentId=1, name='Test Category', status=1}";

        assertEquals(expected, actual);
    }
}
