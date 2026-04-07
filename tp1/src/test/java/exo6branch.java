import org.example.FizzBuzz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo6branch {
    // Branche : n <= 1 → true
    @Test
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
    }

    // Branche : n % 15 == 0
    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }

    // Branche : n % 15 != 0, n % 3 == 0
    @Test
    void testFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    // Branche : n % 3 != 0, n % 5 == 0
    @Test
    void testBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    // Branche : aucun divisible → return String.valueOf
    @Test
    void testNumber() {
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }
}
