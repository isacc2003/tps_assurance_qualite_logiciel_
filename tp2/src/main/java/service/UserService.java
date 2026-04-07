// src/main/java/service/UserService.java
package service;

import model.User;
import repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    // Injection de dépendance par constructeur
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        return userRepository.findUserById(id);
    }
}