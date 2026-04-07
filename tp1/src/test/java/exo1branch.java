import org.example.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo1branch {
    @Test
    void testNullString() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }


    @Test
    void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }


    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }


    @Test
    void testPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }
}

