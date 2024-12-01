import java.util.Random;

/**
 * Main class to demonstrate the Extended Euclidean Algorithm.
 */
public class Main {
    public static void main(String[] args) {
        int modulus = 999331;

        // Task 1: Find the modular inverse of 296 mod 999331
        int a = 296;
        try {
            int inverse = ExtendedEuclideanAlgorithm.modularInverse(a, modulus);
            System.out.println("Task 1");
            System.out.println("Modular inverse of " + a + " mod " + modulus + ": " + inverse);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 2: Generate a random number in Z_999331 and find its modular inverse
        Random random = new Random();
        int randomNumber;

        // Ensure the random number is coprime to modulus
        do {
            randomNumber = random.nextInt(modulus - 1) + 1; // Random number in range [1, modulus-1]
        } while (ExtendedEuclideanAlgorithm.extendedGcd(randomNumber, modulus)[0] != 1);

        try {
            int randomInverse = ExtendedEuclideanAlgorithm.modularInverse(randomNumber, modulus);
            System.out.println("Task 2");
            System.out.println("Random number in Z_" + modulus + ": " + randomNumber);
            System.out.println("Modular inverse of " + randomNumber + " mod " + modulus + ": " + randomInverse);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
