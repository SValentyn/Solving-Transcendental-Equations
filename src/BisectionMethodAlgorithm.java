import java.util.Locale;

public class BisectionMethodAlgorithm {

    public final static double EPS = 0.00001;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        double a = 1;
        double b = 2;

        System.out.println("Find an approximate solution (finding the root) to the equation: 2x^3 + 4x - 15 = 0 on the interval [1;2] with epsilon = 0.00001");
        System.out.println("\nThe solution of the equation:");
        bisectionMethod(a, b);
    }

    public static void bisectionMethod(double a, double b) {
        double c; // midpoint
        double x; // approximate value of 'x'

        while (Math.abs(b - a) > 2 * EPS) {
            c = (a + b) / 2;

            if (function(a) * function(c) <= 0) {
                b = c;
            } else {
                a = c;
            }

            x = (a + b) / 2;

            System.out.printf("x = %.8f f(x) = %.8f\n", x, function(x));
        }
    }

    private static double function(double x) {
        return 2 * Math.pow(x, 3) + 4 * x - 15;
    }
}
