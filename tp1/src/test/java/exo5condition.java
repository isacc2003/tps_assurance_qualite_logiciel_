import org.example.RomanNumeral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class exo5condition {

    // Condition : n < 1 → true
    @Test
    void testNTooSmall() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    // Condition : n < 1 → false, n > 3999 → true
    @Test
    void testNTooBig() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    // Condition : n < 1 → false, n > 3999 → false, i <= symbols.length → true, n > values[i] → true
    @Test
    void testNormal() {
        assertEquals("III", RomanNumeral.toRoman(3));
    }

    // Condition : n > values[i] → false (while non exécutée pour ce symbole)
    @Test
    void testMixed() {
        assertEquals("IV", RomanNumeral.toRoman(4));
    }
}