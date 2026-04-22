package service;

import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import repository.UserRepository;
import org.example.Application;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@Testcontainers
class UserServiceIntegrationTest {

    @Container
    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.30")
            .withDatabaseName("testdb")
            .withUsername("root")
            .withPassword("password");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("spring.jpa.show-sql", () -> "true");
        registry.add("spring.datasource.driver-class-name", () -> "com.mysql.cj.jdbc.Driver");
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testGetUserById_returnsCorrectUser() {
        // Arrange
        User user = new User(42L, "Alice Docker", "alice.docker@mail.com");
        userRepository.save(user);

        // Act
        User result = userService.getUserById(42L);

        // Assert
        assertNotNull(result);
        assertEquals(42L, result.getId());
        assertEquals("Alice Docker", result.getName());
    }

    @Test
    void testGetUserById_userNotFound_returnsNull() {
        // Act
        User result = userService.getUserById(99L);

        // Assert
        assertNull(result);
    }
}
