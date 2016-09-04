package emag.lapachet.service;

import emag.lapachet.repository.CategoryRepository;
import junit.framework.TestCase;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;

import java.util.List;

public class SqlCategoryTest extends TestCase
{
    private CategoryRepository categoryRepository;
    private SqlCategory service;

    public void setUp() {
        categoryRepository = createNiceMock(CategoryRepository.class);
        service = new SqlCategory();
    }

    public void testGetDailyCategories()
    {
        expect(categoryRepository.getDailyCategories("2016-09-04")).andReturn(createNiceMock(List.class)).times(1);
    }

    public void testgetAllCategories()
    {
        expect(categoryRepository.getAllCategories()).andReturn(createNiceMock(List.class)).times(1);
    }
}
