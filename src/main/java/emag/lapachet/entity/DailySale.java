package emag.lapachet.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class DailySale
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private java.util.Date date;

    public DailySale()
    {
        super();
    }

    public DailySale(Integer id, Date date) {
        super();
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DailySaleInterface{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
