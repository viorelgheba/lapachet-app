package emag.lapachet.service;

import emag.lapachet.entity.Product;
import emag.lapachet.modelInterface.ProductInterface;
import emag.lapachet.repository.ProductRepository;
import emag.lapachet.util.GenericList;

import java.util.List;
import java.util.UUID;

public class SqlProduct implements ProductInterface
{
    private ProductRepository productRepository;
    public SqlProduct() {
        this.productRepository = new ProductRepository();
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
    public Product getProduct(Integer productId) {
        return new Product();
    }

    @Override
    public List<Product> getAllProducts() {
        /* TODO: get element form db */
        GenericList<Product> listProducts = new GenericList<>();
        Product product = new Product();
        Product product2 = new Product();
        listProducts.addElement(product);
        listProducts.addElement(product2);

        return listProducts.getList();
    }
}
