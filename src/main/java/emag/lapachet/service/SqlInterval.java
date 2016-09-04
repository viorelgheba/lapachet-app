package emag.lapachet.service;

import emag.lapachet.modelInterface.IntervalInterface;
import emag.lapachet.repository.IntervalRepository;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

public class SqlInterval implements IntervalInterface
{
    private IntervalRepository intervalRepository;

    public SqlInterval(IntervalRepository intervalRepository) {
        this.intervalRepository = intervalRepository;
    }

    @Override
    public UUID addInterval(Time timeStart, Time timeEnd, Integer maxSales) {
        return null;
    }

    @Override
    public UUID editInterval(UUID interval, Time timeStart, Time timeEnd, Integer maxSales) {
        return null;
    }

    @Override
    public UUID deleteInterval(UUID interval) {
        return null;
    }

    @Override
    public List getAllIntervals() {
        return (List) this.intervalRepository.getAllIntervals();
    }
}
