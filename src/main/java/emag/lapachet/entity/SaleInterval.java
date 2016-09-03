package emag.lapachet.entity;

import javax.persistence.*;

@Entity
@Table
public class SaleInterval
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer intervalId;
    private Integer dailySaleId;
    private Integer clients;

    public SaleInterval() {
        super();
    }

    public SaleInterval(Integer id, Integer intervalId, Integer dailySaleId, Integer clients) {
        super();
        this.id = id;
        this.intervalId = intervalId;
        this.dailySaleId = dailySaleId;
        this.clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "SaleInterval{" +
                "id=" + id +
                ", intervalId=" + intervalId +
                ", dailySaleId=" + dailySaleId +
                ", clients=" + clients +
                '}';
    }
}
