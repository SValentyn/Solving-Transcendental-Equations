public class MullerMethodAlgorithm {

    public final static double EPS = 0.00001;
    public final static int MAX_ITERATIONS = 10000;

    public static void main(String[] args) {
        double a = 0, b = 1, c = 2;

        System.out.println("Find an approximate solution (finding the root) to the equation: 2x^3 + 4x - 15 = 0 on the interval [1;2] with epsilon = 0.00001");
        System.out.println("\nThe solution of the equation:");
        mullerMethod(a, b, c);
    }

    private static void mullerMethod(double a, double b, double c) {
        double x;

        for (int i = 0; ; ++i) {

            // Calculating various constants required to calculate x3
            double f1 = function(a);
            double f2 = function(b);
            double f3 = function(c);

            double d1 = f1 - f3;
            double d2 = f2 - f3;

            double h1 = a - c;
            double h2 = b - c;

            double a0 = f3;
            double a1 = (((d2 * Math.pow(h1, 2)) - (d1 * Math.pow(h2, 2))) / ((h1 * h2) * (h1 - h2)));
            double a2 = (((d1 * h2) - (d2 * h1)) / ((h1 * h2) * (h1 - h2)));

            double result = ((-2 * a0) / (a1 + Math.abs(Math.sqrt(a1 * a1 - 4 * a0 * a2))));
            double y = ((-2 * a0) / (a1 - Math.abs(Math.sqrt(a1 * a1 - 4 * a0 * a2))));

            // Taking the root which is closer to x2
            if (result >= y) {
                x = result + c;
            } else {
                x = y + c;
            }

            a = b;
            b = c;
            c = x;

            if (i > MAX_ITERATIONS) {
                System.out.println("Root cannot be found using Muller's method");
                break;
            }

            System.out.printf("x = %.6f f(x) = %.8f\n", x, result);

            if (Math.abs(result) < EPS) {
                break;
            }
        }
    }

    private static double function(double x) {
        return 2 * Math.pow(x, 3) + 4 * x - 15;
    }
}
