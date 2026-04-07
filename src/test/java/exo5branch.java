import org.example.RomanNumeral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class exo5branch {

    // Branche : n < 1
    @Test
    void testBelowRange() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    // Branche : n > 3999
    @Test
    void testAboveRange() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    // Branche : for loop parcourue, while interne exécutée au moins une fois
    @Test
    void testMille() {
        assertEquals("M", RomanNumeral.toRoman(1000));
    }

    // Branche : while interne non exécutée pour certains symboles
    @Test
    void testCombine() {
        assertEquals("XIV", RomanNumeral.toRoman(14));
    }

    // Branche : nombre maximal
    @Test
    void testMax() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }
}