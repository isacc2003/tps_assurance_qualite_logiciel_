import org.example.RomanNumeral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class exo5line {

    @Test
    void testOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void testSimple() {
        assertEquals("I", RomanNumeral.toRoman(1));
    }

    @Test
    void testComplex() {
        assertEquals("MCMXCIX", RomanNumeral.toRoman(1999));
    }
}
