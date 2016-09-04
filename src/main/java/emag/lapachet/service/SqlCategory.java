package emag.lapachet.service;

import emag.lapachet.modelInterface.CategoryInterface;
import emag.lapachet.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

public class SqlCategory implements CategoryInterface
{
    private CategoryRepository categoryRepository;
    public SqlCategory() {
        this.categoryRepository = new CategoryRepository();
    }

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
    public List getAllCategories() {
        return (List) this.categoryRepository.getAllCategories();
    }
}
