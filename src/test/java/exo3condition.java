import org.example.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo3condition {
    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }

    // low < high → false immédiatement
    @Test
    void testEmptyArray() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1));
    }

    // low < high → true, array[mid] == element → true
    @Test
    void testFoundExact() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 5));
    }

    // array[mid] == element → false, array[mid] <= element → true
    @Test
    void testGoRight() {
        assertEquals(3, BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 7));
    }

    // array[mid] <= element → false (array[mid] > element)
    @Test
    void testGoLeft() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 1));
    }
}

