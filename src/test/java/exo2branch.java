import org.example.Anagram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo2branch {
    // Branche : s1 == null → true
    @Test
    void testNullS1() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    // Branche : s2 == null → true (s1 non null)
    @Test
    void testNullS2() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    // Branche : longueurs différentes
    @Test
    void testDifferentLength() {
        assertFalse(Anagram.isAnagram("abc", "abcd"));
    }

    // Branche : longueurs égales, c != 0 → return false
    @Test
    void testNotAnagram() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }

    // Branche : longueurs égales, tous c == 0 → return true
    @Test
    void testIsAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }
}
