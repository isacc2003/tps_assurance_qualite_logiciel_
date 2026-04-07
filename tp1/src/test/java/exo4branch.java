import org.example.QuadraticEquation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo4branch {
    // Branche : a == 0
    @Test
    void testAIsZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 1));
    }

    // Branche : delta < 0
    @Test
    void testNoRealRoots() {
        assertNull(QuadraticEquation.solve(1, 0, 5));
    }

    // Branche : delta == 0
    @Test
    void testOneRoot() {
        double[] r = QuadraticEquation.solve(1, -2, 1);
        assertArrayEquals(new double[]{1.0}, r, 1e-9);
    }

    // Branche : delta > 0
    @Test
    void testTwoRoots() {
        double[] r = QuadraticEquation.solve(1, -5, 6);
        assertEquals(2, r.length);
        assertEquals(3.0, r[0], 1e-9);
        assertEquals(2.0, r[1], 1e-9);
    }


}
