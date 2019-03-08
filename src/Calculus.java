import java.util.function.Function;

public class Calculus {

    private static final double deltaX = 0.0001;
    public static final double e = 2.718281828459045;
    public static final double pi = Math.PI;


    public static double definiteIntegral(Function<Double, Double> f, double x1, double x2){
        int flip = 1;
        if(x1 > x2){
            double temp = x1;
            x1 = x2;
            x2 = temp;
            flip = -1;
        }
        double area = 0;
        for (double i = x1; i < x2; i += deltaX) {
            area +=  deltaX * f.apply(i);
        }
        return flip*(area);
    }

    public static double derivativeAtPoint(Function<Double, Double> f, double x){
        double slope1 = (f.apply(x)-f.apply(x-deltaX))/deltaX;
        double slope2 = (f.apply(x + deltaX)-f.apply(x))/deltaX;
        return roundOrNot(avg(slope1,slope2));
    }

    private static double roundOrNot(double a){
        if(a%0.5 < 0.05){
            return a - a%0.5;
        }else if((a + 0.001) %0.5 < 0.05){
            return a + 0.001 - (a+0.001)%0.5;
        }
        return a;
    }

    private static double avg(double a, double b) {
        return (a+b)/2;
    }
}
