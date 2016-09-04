package emag.lapachet.service;

import emag.lapachet.modelInterface.ProductInterface;
import emag.lapachet.repository.ProductRepository;
import org.bson.Document;
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
    public Document getProduct(Integer productId) {
        return productRepository.getProduct(productId);
    }

    @Override
    public List getAllProducts() {
        return (List) this.productRepository.getAllProducts();
    }

    public List<Document> getCategoryProducts(String date)
    {
        return this.productRepository.getCategoryProducts(date);
    }

    public List<Document> getCategoryProducts(String date, Integer categoryId)
    {
        return this.productRepository.getCategoryProducts(date, categoryId);
    }
}
