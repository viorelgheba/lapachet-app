package emag.lapachet.modelInterface;

import emag.lapachet.entity.Product;
import org.bson.Document;

import java.util.List;
import java.util.UUID;

public interface ProductInterface
{
    UUID addProduct(Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit);
    UUID editProduct(UUID product, Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit);
    UUID deleteProduct(UUID product);
    Document getProduct(Integer product);
    List getAllProducts();
}
