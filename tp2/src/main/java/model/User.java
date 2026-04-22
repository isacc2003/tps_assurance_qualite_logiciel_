
// src/main/java/model/User.java
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    private long id;
    private String name;
    private String email;

    // JPA requires a no-arg constructor
    protected User() {}

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId()     { return id; }
    public String getName() { return name; }
    public String getEmail(){ return email; }
}