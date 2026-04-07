// src/main/java/exception/InvalidProductDataException.java
package exception;

public class InvalidProductDataException extends RuntimeException {
    public InvalidProductDataException(String message) {
        super(message);
    }
}