package emag.lapachet.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class DailySaleItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double price;
    private Integer productId;
    private Integer dailySaleId;
    private Integer categoryId;
    private Date date;
    private Integer quantity;

    public DailySaleItem() {
        super();
    }

    public DailySaleItem(Integer id, Double price, Integer productId, Integer dailySaleId, Integer categoryId, Date date, Integer quantity) {
        this.id = id;
        this.price = price;
        this.productId = productId;
        this.dailySaleId = dailySaleId;
        this.categoryId = categoryId;
        this.date = date;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
        return "DailySaleItemInterface{" +
                "id=" + id +
                ", price=" + price +
                ", productId=" + productId +
                ", dailySaleId=" + dailySaleId +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
    }
}
