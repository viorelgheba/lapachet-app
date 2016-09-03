package emag.lapachet.modelInterface;

import emag.lapachet.entity.Products;
import emag.lapachet.service.GenericList;

import java.util.UUID;

public interface ProductsInterface
{
    UUID addProduct(Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit);
    UUID editProduct(UUID product, Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit);
    UUID deleteProduct(UUID product);
    Products getProduct(String product);
    GenericList getAllProducts();
}
