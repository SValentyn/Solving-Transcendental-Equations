import java.util.Locale;

public class CombinedMethodAlgorithm {

    public final static double EPS = 0.00001;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        double a = 1;
        double b = 2;

        System.out.println("Find an approximate solution (finding the root) to the equation: 2x^3 + 4x - 15 = 0 on the interval [1;2] with epsilon = 0.00001");

        System.out.println("\nThe solution of the equation in the first way:");
        combinedMethod_1(a, b);

        System.out.println("\nThe solution of the equation in the second way:");
        combinedMethod_2(a, b);
    }

    private static void combinedMethod_1(double a, double b) {
        while (Math.abs(a - b) > 2 * EPS) {
            if (function(a) * doubleDerivativeFunction(a) < 0) {
                a += (b - a) / (function(a) - function(b)) * function(a);
            } else {
                a -= function(a) / derivativeFunction(a);
            }
            if (function(b) * doubleDerivativeFunction(b) < 0) {
                b += (a - b) / (function(b) - function(a)) * function(b);
            } else {
                b -= function(b) / function(b);
            }

            double x = (a + b) / 2.0;

            System.out.printf("x = %.8f f(x) = %.8f\n", x, function(x));
        }
    }

    private static void combinedMethod_2(double a, double b) {
        while (Math.abs(a - b) > 2 * EPS) {
            if (function(a) * doubleDerivativeFunction(a) < 0) {
                a -= (function(a) * (a - b)) / (function(a) - function(b));
            } else {
                a -= function(a) / derivativeFunction(a);
            }
            if (function(b) * doubleDerivativeFunction(b) < 0) {
                b -= (function(b) * (b - a)) / (function(b) - function(a));
            } else {
                b -= function(b) / derivativeFunction(b);
            }

            double x = (a + b) / 2.0;

            System.out.printf("x = %.8f f(x) = %.8f\n", x, function(x));
        }
    }

    private static double function(double x) {
        return 2 * Math.pow(x, 3) + 4 * x - 15;
    }

    static double derivativeFunction(double x) {
        return 6 * Math.pow(x, 2) + 4;
    }

    static double doubleDerivativeFunction(double x) {
        return 12 * x;
    }
}
