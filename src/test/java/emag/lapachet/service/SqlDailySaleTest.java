package emag.lapachet.service;

import emag.lapachet.entity.DailySale;
import emag.lapachet.repository.DailySaleRepository;
import junit.framework.TestCase;

import java.util.ArrayList;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;

public class SqlDailySaleTest extends TestCase
{
    private DailySaleRepository dailySaleRepository;
    private SqlDailySale service;

    public void setUp() {
        dailySaleRepository = createNiceMock(DailySaleRepository.class);
        service = new SqlDailySale();
    }

    public void testDetAllDailySales()
    {
        expect(dailySaleRepository.getAllDailySales()).andReturn(new ArrayList<DailySale>()).times(1);
    }
}
