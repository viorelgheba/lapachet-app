package emag.lapachet.service;

import emag.lapachet.entity.Category;
import emag.lapachet.modelInterface.CategoryInterface;
import emag.lapachet.util.GenericList;

import java.util.List;
import java.util.UUID;

public class SqlCategory implements CategoryInterface {
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
        GenericList<Category> categories = new GenericList<>();
        Category category = new Category();

        categories.addElement(category);
        categories.addElement(category);
        categories.addElement(category);

        return categories.getList();
    }
}
