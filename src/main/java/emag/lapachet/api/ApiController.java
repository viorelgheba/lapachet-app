package emag.lapachet.api;

import emag.lapachet.service.SqlProducts;

public class ApiController
{
    public static void main(String[] args) {
        new ApiProducts(new SqlProducts());
    }
}
