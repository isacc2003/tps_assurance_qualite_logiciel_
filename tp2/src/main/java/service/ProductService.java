// src/main/java/service/ProductService.java
package service;

import api.ProductApiClient;
import exception.ApiException;
import exception.InvalidProductDataException;
import model.Product;

public class ProductService {

    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("L'identifiant produit ne peut pas être vide");
        }

        Product product;
        try {
            product = productApiClient.getProduct(productId);
        } catch (ApiException e) {
            throw new ApiException("Échec de l'appel API pour le produit : " + productId, e);
        }

        // Validation du format des données reçues
        if (product == null) {
            throw new InvalidProductDataException("L'API a retourné un produit null");
        }
        if (product.getName() == null || product.getName().isBlank()) {
            throw new InvalidProductDataException("Le nom du produit est invalide ou manquant");
        }
        if (product.getPrice() < 0) {
            throw new InvalidProductDataException("Le prix du produit est invalide : " + product.getPrice());
        }

        return product;
    }
}