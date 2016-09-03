package emag.lapachet.entity;

import javax.persistence.*;

@Entity
@Table
public class Categories
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer parent;
    private String name;

    public Categories()
    {
        super();
    }


    public Categories(Integer id, Integer parent, String name) {
        super();
        this.id = id;
        this.parent = parent;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
