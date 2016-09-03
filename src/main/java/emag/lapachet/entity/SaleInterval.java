package emag.lapachet.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class SaleInterval
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer intervalId;
    private Integer dailySaleId;
    private Integer clients;

    public SaleInterval() {
        super();
    }

    public SaleInterval(Integer intervalId, Integer dailySaleId, Integer clients) {
        super();
        this.intervalId = intervalId;
        this.dailySaleId = dailySaleId;
        this.clients = clients;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getIntervalId() {
        return intervalId;
    }

    public void setIntervalId(Integer intervalId) {
        this.intervalId = intervalId;
    }

    public Integer getDailySaleId() {
        return dailySaleId;
    }

    public void setDailySaleId(Integer dailySaleId) {
        this.dailySaleId = dailySaleId;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "SaleIntervalInterface{" +
                "id=" + id +
                ", intervalId=" + intervalId +
                ", dailySaleId=" + dailySaleId +
                ", clients=" + clients +
                '}';
    }
}
