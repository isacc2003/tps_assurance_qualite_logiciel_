import org.example.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class exo3branch { // array == null → true
    // Branche : array == null
    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }

    // Branche : while → false immédiatement (tableau vide)
    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.binarySearch(arr, 5));
    }

    // Branche : array[mid] == element → true
    @Test
    void testFoundAtMid() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(arr, 5));
    }

    // Branche : array[mid] <= element → low = mid + 1
    @Test
    void testFoundInRightHalf() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(3, BinarySearch.binarySearch(arr, 7));
    }

    // Branche : array[mid] > element → high = mid - 1
    @Test
    void testFoundInLeftHalf() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearch.binarySearch(arr, 1));
    }

    // Branche : return -1
    @Test
    void testNotFound() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(arr, 6));
    }
}
