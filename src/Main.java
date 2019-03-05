import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Double, Double> f = a -> a*a;
        System.out.println(stats.normalCDF(-1.96));
        for (double i = 0; i < 10; i++) {
            System.out.println(Calculus.derivativeAtPoint(f, i));
        }
    }
}
