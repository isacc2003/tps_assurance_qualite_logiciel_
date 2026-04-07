import org.example.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo3line {
    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }

    @Test
    void testElementFound() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(arr, 5));
    }

    @Test
    void testElementNotFound() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(arr, 4));
    }
}
