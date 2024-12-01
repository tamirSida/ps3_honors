/**
 * Class for Extended Euclidean Algorithm and modular inverse computation.
 */
public class ExtendedEuclideanAlgorithm {

    /**
     * Computes GCD and coefficients x, y such that gcd = ax + by using the Extended Euclidean Algorithm.
     *
     * @param a the first number
     * @param b the second number
     * @return an array containing [gcd, x, y]
     */
    public static int[] extendedGcd(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        }

        int[] qr = division.div(a, b); // Use division class
        int q = qr[0];
        int r = qr[1];

        int[] result = extendedGcd(b, r);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2];

        int x = y1;
        int y = x1 - q * y1;

        return new int[]{gcd, x, y};
    }

    /**
     * Computes the modular inverse of a number modulo N.
     *
     * @param a the number whose modular inverse is to be computed
     * @param N the modulus
     * @return the modular inverse of a modulo N
     * @throws IllegalArgumentException if the modular inverse does not exist
     */
    public static int modularInverse(int a, int N) {
        int[] result = extendedGcd(a, N);
        int gcd = result[0];
        int x = result[1];

        if (gcd != 1) {
            throw new IllegalArgumentException("Modular inverse does not exist for " + a + " mod " + N);
        }

        return (x % N + N) % N; // Ensure result is non-negative
    }
}
