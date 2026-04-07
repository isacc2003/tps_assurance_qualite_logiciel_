import org.example.QuadraticEquation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo4line {
    @Test
    void testAIsZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }

    @Test
    void testNegativeDelta() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // delta = -4
    }

    @Test
    void testZeroDelta() {
        double[] r = QuadraticEquation.solve(1, 2, 1); // delta = 0
        assertEquals(1, r.length);
        assertEquals(-1.0, r[0]);
    }

    @Test
    void testPositiveDelta() {
        double[] r = QuadraticEquation.solve(1, -5, 6); // delta = 1, racines 3 et 2
        assertEquals(2, r.length);
    }

}
