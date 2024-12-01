/**
 * This class provides a method for performing integer division with remainder.
 */
public class division {

    /**
     * Performs integer division with remainder.
     *
     * @param x the dividend
     * @param y the divisor
     * @return an array containing the quotient and the remainder
     * @throws IllegalArgumentException if the input is invalid
     */
    public static int[] div(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("/ by zero");
        }
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid input: negative numbers are not allowed");
        }
        if (x == 0) {
            return new int[]{0, 0};
        }

        int[] qr = div(x / 2, y);
        int q = 2 * qr[0];
        int r = 2 * qr[1];

        if (isOdd(x)) {
            r = r + 1;
        }

        if (r >= y) {
            r = r - y;
            q = q + 1;
        }

        return new int[]{q, r};
    }

    /**
     * Checks if a number is odd.
     *
     * @param x the number to check
     * @return true if the number is odd, false otherwise
     */
    public static boolean isOdd(int x) {
        return x % 2 != 0;
    }
}