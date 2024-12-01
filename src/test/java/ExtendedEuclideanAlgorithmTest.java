import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtendedEuclideanAlgorithmTest {

    @Test
    public void testExtendedGcd() {
        // Test 1: Basic GCD
        int[] result = ExtendedEuclideanAlgorithm.extendedGcd(30, 20);
        assertEquals(10, result[0]); // GCD
        assertTrue(30 * result[1] + 20 * result[2] == 10);

        // Test 2: GCD with zero
        result = ExtendedEuclideanAlgorithm.extendedGcd(0, 20);
        assertEquals(20, result[0]);
        assertEquals(0, result[1]);
        assertEquals(1, result[2]);

        // Test 3: GCD of coprime numbers
        result = ExtendedEuclideanAlgorithm.extendedGcd(35, 64);
        assertEquals(1, result[0]);
        assertTrue(35 * result[1] + 64 * result[2] == 1);
    }


w

    @Test
    public void testEdgeCases() {
        // Modular inverse of 1
        int modulus = 999331;
        int inverse = ExtendedEuclideanAlgorithm.modularInverse(1, modulus);
        assertEquals(1, inverse);

        // Modular inverse does not exist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExtendedEuclideanAlgorithm.modularInverse(0, modulus);
        });
        assertEquals("Modular inverse does not exist for 0 mod 999331", exception.getMessage());
    }
}
