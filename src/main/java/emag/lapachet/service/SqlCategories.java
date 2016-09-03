package emag.lapachet.service;

import emag.lapachet.entity.Category;
import emag.lapachet.modelInterface.CategoriesInterface;
import emag.lapachet.util.Db;
import emag.lapachet.util.GenericList;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SqlCategories implements CategoriesInterface {

    public SqlCategories() {
    }

    @Override
    public UUID addCategory(Integer parent, String name) {
        return null;
    }

    @Override
    public UUID editCategory(UUID category, Integer parent, String name) {
        return null;
    }

    @Override
    public UUID deleteCategory(UUID product) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();

        try {
            /*List<Category> categories = conn.createQuery("select * from category")
                    .executeAndFetch(Category.class);

            return categories;*/

            Statement stmt = Db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM category");
            while (rs.next()) {
                System.out.println("Read from DB: " + rs.getTimestamp("name"));
            }
        } catch (SQLException | URISyntaxException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
