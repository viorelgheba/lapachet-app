package emag.lapachet.modelInterface;

import emag.lapachet.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductInterface
{
    UUID addProduct(Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit);
    UUID editProduct(UUID product, Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit);
    UUID deleteProduct(UUID product);
    Product getProduct(Integer product);
    List<Product> getAllProducts();
}
