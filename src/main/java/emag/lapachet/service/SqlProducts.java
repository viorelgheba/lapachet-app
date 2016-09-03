package emag.lapachet.service;

import emag.lapachet.entity.Products;
import emag.lapachet.modelInterface.ProductsInterface;

import java.util.UUID;

public class SqlProducts implements ProductsInterface
{

    public SqlProducts() {
    }

    @Override
    public UUID addProduct(Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit) {
        return null;
    }

    @Override
    public UUID editProduct(UUID product, Integer categoryId, String name, String description, Double basePrice, Integer grammage, String unit) {
        return null;
    }

    @Override
    public UUID deleteProduct(UUID product) {
        return null;
    }

    @Override
    public GenericList getAllProducts() {
        /* TODO: get element form db */
        GenericList<Products> listProducts = new GenericList<Products>();
        Products products = new Products();
        Products products2 = new Products();
        listProducts.addElement(products);
        listProducts.addElement(products2);

        return listProducts;
    }
}
