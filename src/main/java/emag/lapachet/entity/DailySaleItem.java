package emag.lapachet.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table
public class DailySaleItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Float price;
    private Integer productId;
    private Integer dailySaleId;
    private Date date;
    private Integer quantity;

    public DailySaleItem() {
        super();
    }

    public DailySaleItem(Float price, Integer productId, Integer dailySaleId, Date date, Integer quantity) {
        super();
        this.price = price;
        this.productId = productId;
        this.dailySaleId = dailySaleId;
        this.date = date;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDailySaleId() {
        return dailySaleId;
    }

    public void setDailySaleId(Integer dailySaleId) {
        this.dailySaleId = dailySaleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DailySaleItem{" +
                "id=" + id +
                ", price=" + price +
                ", productId=" + productId +
                ", dailySaleId=" + dailySaleId +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
    }
}
