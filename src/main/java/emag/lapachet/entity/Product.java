package emag.lapachet.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer categoryId;
    private String name;
    private String description;
    private Double basePrice;
    private Integer grammage;
    private String unit;

    public Product(Integer id, Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.grammage = grammage;
        this.unit = unit;
    }

    public Product() {
        super();
        this.categoryId = 0;
        this.name = "";
        this.description = "";
        this.basePrice = 0.00;
        this.grammage = 0;
        this.unit = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getGrammage() {
        return grammage;
    }

    public void setGrammage(Integer grammage) {
        this.grammage = grammage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ProductInterface{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", basePrice=" + basePrice +
                ", grammage=" + grammage +
                ", unit='" + unit + '\'' +
                '}';
    }
}
