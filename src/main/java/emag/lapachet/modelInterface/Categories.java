package emag.lapachet.modelInterface;

import emag.lapachet.service.GenericList;

import java.util.UUID;

public interface Categories
{
    UUID addCategory(Integer parent, String name);
    UUID editCategory(UUID category, Integer parent, String name);
    UUID deleteCategory(UUID product);
    GenericList getAllCategories();
}
