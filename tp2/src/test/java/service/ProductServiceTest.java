// src/test/java/service/ProductServiceTest.java
package service;

import api.ProductApiClient;
import exception.ApiException;
import exception.InvalidProductDataException;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductApiClient productApiClient;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productApiClient);
    }

    // ── Scénario 1 : récupération réussie ───────────────────────────────────

    @Test
    void testGetProduct_success_returnsProduct() {
        // ARRANGE
        String productId = "PROD-123";
        Product expected = new Product("PROD-123", "Clavier mécanique", 89.99);
        when(productApiClient.getProduct(productId)).thenReturn(expected);

        // ACT
        Product result = productService.getProduct(productId);

        // ASSERT
        assertNotNull(result);
        assertEquals("PROD-123", result.getId());
        assertEquals("Clavier mécanique", result.getName());
        assertEquals(89.99, result.getPrice(), 0.001);

        // VERIFY : l'API client a bien été appelé avec le bon ID
        verify(productApiClient, times(1)).getProduct("PROD-123");
    }

    // ── Scénario 2 : format de données incompatible ─────────────────────────

    @Test
    void testGetProduct_invalidData_nullName_throwsException() {
        // ARRANGE : l'API renvoie un produit avec un nom null
        String productId = "PROD-456";
        Product invalidProduct = new Product("PROD-456", null, 50.0);
        when(productApiClient.getProduct(productId)).thenReturn(invalidProduct);

        // ACT + ASSERT : on attend une InvalidProductDataException
        InvalidProductDataException exception = assertThrows(
                InvalidProductDataException.class,
                () -> productService.getProduct(productId)
        );

        assertTrue(exception.getMessage().contains("nom du produit est invalide"));
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void testGetProduct_invalidData_negativePrice_throwsException() {
        // ARRANGE : l'API renvoie un prix négatif (format incohérent)
        String productId = "PROD-789";
        Product invalidProduct = new Product("PROD-789", "Produit cassé", -10.0);
        when(productApiClient.getProduct(productId)).thenReturn(invalidProduct);

        // ACT + ASSERT
        InvalidProductDataException exception = assertThrows(
                InvalidProductDataException.class,
                () -> productService.getProduct(productId)
        );

        assertTrue(exception.getMessage().contains("prix du produit est invalide"));
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void testGetProduct_invalidData_nullProduct_throwsException() {
        // ARRANGE : l'API renvoie null (réponse vide)
        String productId = "PROD-000";
        when(productApiClient.getProduct(productId)).thenReturn(null);

        // ACT + ASSERT
        assertThrows(
                InvalidProductDataException.class,
                () -> productService.getProduct(productId)
        );

        verify(productApiClient).getProduct(productId);
    }

    // ── Scénario 3 : échec d'appel API ──────────────────────────────────────

    @Test
    void testGetProduct_apiFailure_throwsApiException() {
        // ARRANGE : l'API lève une exception (timeout, 500, réseau...)
        String productId = "PROD-ERR";
        when(productApiClient.getProduct(productId))
                .thenThrow(new ApiException("Service indisponible"));

        // ACT + ASSERT
        ApiException exception = assertThrows(
                ApiException.class,
                () -> productService.getProduct(productId)
        );

        assertTrue(exception.getMessage().contains("Échec de l'appel API"));
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void testGetProduct_emptyId_throwsIllegalArgument() {
        // ARRANGE : aucun mock nécessaire — l'exception est levée avant l'appel API

        // ACT + ASSERT
        assertThrows(
                IllegalArgumentException.class,
                () -> productService.getProduct("")
        );

        // VERIFY : le client API n'a jamais été appelé
        verifyNoInteractions(productApiClient);
    }
}