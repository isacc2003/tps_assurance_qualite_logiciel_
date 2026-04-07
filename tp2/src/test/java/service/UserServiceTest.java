// src/test/java/service/UserServiceTest.java
package service;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;  // Mockito crée le mock automatiquement

    private UserService userService;

    @BeforeEach
    void setUp() {
        // On injecte le mock dans UserService
        userService = new UserService(userRepository);
    }

    @Test
    void testGetUserById_returnsCorrectUser() {
        // ARRANGE : définir le comportement du mock
        long userId = 42L;
        User expectedUser = new User(42L, "Alice", "alice@mail.com");
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);

        // ACT : appeler la méthode testée
        User result = userService.getUserById(userId);

        // ASSERT : vérifier le résultat
        assertNotNull(result);
        assertEquals(42L, result.getId());
        assertEquals("Alice", result.getName());

        // VERIFY : vérifier que findUserById a bien été appelé avec l'argument 42
        verify(userRepository, times(1)).findUserById(42L);
    }

    @Test
    void testGetUserById_userNotFound_returnsNull() {
        // ARRANGE : le repo renvoie null si l'utilisateur n'existe pas
        when(userRepository.findUserById(99L)).thenReturn(null);

        // ACT
        User result = userService.getUserById(99L);

        // ASSERT
        assertNull(result);

        // VERIFY : l'appel a bien eu lieu avec le bon argument
        verify(userRepository).findUserById(99L);
    }
}