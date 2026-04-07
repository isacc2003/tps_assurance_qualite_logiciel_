
import org.example.Anagram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo2condition {// Condition : s1 == null → true  (court-circuit, s2 non évalué)
    @Test
    void testS1Null() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }


    @Test
    void testS2Null() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }


    @Test
    void testDifferentLength() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }


    @Test
    void testNotAnagram() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }


    @Test
    void testIsAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }
}
