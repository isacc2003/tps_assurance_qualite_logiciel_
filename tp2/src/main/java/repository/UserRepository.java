// src/main/java/repository/UserRepository.java
package repository;

import model.User;

public interface UserRepository {
    User findUserById(long id);
}