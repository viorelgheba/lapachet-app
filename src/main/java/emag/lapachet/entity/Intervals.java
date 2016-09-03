package emag.lapachet.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table
public class Intervals
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Time timeStart;
    private Time timeEnd;
    private Integer maxSales;

    public Intervals() {
        super();
    }

    public Intervals(Integer id, Time timeStart, Time timeEnd, Integer maxSales) {
        super();
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.maxSales = maxSales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getMaxSales() {
        return maxSales;
    }

    public void setMaxSales(Integer maxSales) {
        this.maxSales = maxSales;
    }

    @Override
    public String toString() {
        return "Intervals{" +
                "id=" + id +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", maxSales=" + maxSales +
                '}';
    }
}
