package emag.lapachet.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Categories
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer parent;
    private String name;

    public Categories()
    {
        super();
    }

    public Categories(Integer parent, String name) {
        super();
        this.parent = parent;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                '}';
    }
}
