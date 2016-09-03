package emag.lapachet.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table
public class DailySale
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Date date;

    public DailySale()
    {
        super();
    }

    public DailySale(Date date) {
        super();
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
