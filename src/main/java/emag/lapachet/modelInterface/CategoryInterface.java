package emag.lapachet.modelInterface;

import java.util.List;
import java.util.UUID;

public interface CategoryInterface
{
    UUID addCategory(Integer parent, String name);
    UUID editCategory(UUID category, Integer parent, String name);
    UUID deleteCategory(UUID product);
    List getAllCategories();
}
