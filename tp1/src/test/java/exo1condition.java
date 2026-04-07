import org.example.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo1condition {// Condition : s == null → true
    @Test
    void testNullString() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    // Condition : s == null → false, i < j → false (chaîne vide)
    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    // Condition : i < j → true, charAt(i) != charAt(j) → true
    @Test
    void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    // Condition : i < j → true plusieurs fois, charAt(i) != charAt(j) → false
    @Test
    void testPalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }
}
