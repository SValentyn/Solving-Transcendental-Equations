import java.util.Locale;

public class NewtonsMethodAlgorithm {

    public final static double EPS = 0.00001;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        double x0 = 1;

        System.out.println("Find an approximate solution (finding the root) to the equation: 2x^3 + 4x - 15 = 0 with initial x0 = 1 and epsilon = 0.00001");
        System.out.println("\nThe solution of the equation:");
        newtonMethod(x0);
    }

    private static void newtonMethod(double x) {
        double h = function(x) / derivativeFunction(x);

        while (Math.abs(h) >= EPS) {
            h = function(x) / derivativeFunction(x);

            x = x - h; // x(i+1) = x(i) - f(x) / f'(x)

            System.out.printf("x = %.6f f(x) = %.8f\n", x, function(x));
        }
    }

    private static double function(double x) {
        return 2 * Math.pow(x, 3) + 4 * x - 15;
    }

    static double derivativeFunction(double x) {
        return 6 * Math.pow(x, 2) + 4;
    }
}
