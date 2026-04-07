
import org.example.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    @Test
    void testNullString() {
        assertThrows(NullPointerException.class,
                () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    @Test
    void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }
}