// src/main/java/api/ProductApiClient.java
package api;

import model.Product;

public interface ProductApiClient {
    Product getProduct(String productId);
}