import java.util.Locale;

public class SecantMethodAlgorithm {

    public final static double EPS = 0.00001;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        double a = 1;
        double b = 2;

        System.out.println("Find an approximate solution (finding the root) to the equation: 2x^3 + 4x - 15 = 0 on the interval [1;2] with epsilon = 0.00001");

        System.out.println("\nThe solution of the equation in the first way:");
        secantMethod_1(a, b);

        System.out.println("\nThe solution of the equation in the second way:");
        secantMethod_2(a, b);
    }

    public static void secantMethod_1(double a, double b) {
        while (Math.abs(function(b)) > EPS) {
            a = b - ((b - a) * function(b)) / (function(b) - function(a));
            b = a - ((a - b) * function(a)) / (function(a) - function(b));

            System.out.printf("x = %.8f \t f(x) = %.8f\n", b, function(b));
        }
    }

    public static void secantMethod_2(double a, double b) {
        double x_next = 0;
        double tmp;
        do {
            tmp = x_next;
            x_next = b - function(b) * (a - b) / (function(a) - function(b));
            a = b;
            b = tmp;

            System.out.printf("x = %.8f \t f(x) = %.8f\n", x_next, function(x_next));
        } while (Math.abs(x_next - b) > EPS);
    }

    private static double function(double x) {
        if (x == 0) x = EPS;
        return 2 * Math.pow(x, 3) + 4 * x - 15;
    }
}
