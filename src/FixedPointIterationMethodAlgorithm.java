import java.util.Locale;

public class FixedPointIterationMethodAlgorithm {

    private static final double EPS = 0.00001;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        double a = 1;
        double b = 2;

        double x = searchX(a, b, (a + b) / 2);
        double lambda = getLambda(x);

        System.out.println("Find an approximate solution (finding the root) to the equation: 2x^3 + 4x - 15 = 0 on the interval [1;2] with epsilon = 0.00001");
        System.out.printf("The initial 'x' for iterations is: %.8f\n", x);
        System.out.printf("Lambda is equal: %.8f\n\n", lambda);
        iterationMethod(x, lambda);
    }

    /**
     * Substituting 'minRange', 'maxRange' and 'x' into the derived formula and select fmax (maximum result)
     *
     * @param minRange - minimum root for 'x' value
     * @param maxRange - maximum root for 'x' value
     * @param x        - root found from equation
     * @return initial 'x' value for iterations
     */
    public static double searchX(double minRange, double maxRange, double x) {
        double a = 6 * Math.pow(minRange, 2) + 4;
        double b = 6 * Math.pow(maxRange, 2) + 4;
        double c = 6 * Math.pow(x, 2) + 4;
        return a >= b && a >= c ? minRange : b >= a && b >= c ? maxRange : x;
    }

    /**
     * The final formula for iteration is: x - lambda * f(x)
     *
     * @return lambda value
     */
    public static double getLambda(double x) {
        return 1.0 / (6 * Math.pow(x, 2) + 4);
    }

    private static void iterationMethod(double x, double lambda) {
        double x0;
        double fx;
        int count = 0;

        System.out.printf("%s %8s %15s\n", "Iteration", "x", "f(x)");
        do {
            x0 = x;
            x = x - lambda * (2 * Math.pow(x, 3) + 4 * x - 15);
            fx = 2 * Math.pow(x0, 3) + 4 * x0 - 15;
            System.out.printf("%5d %15.8f %15.8f\n", ++count, x0, fx);
        } while (Math.abs(x - x0) >= EPS);
    }
}
