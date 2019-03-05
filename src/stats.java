import java.util.function.Function;

public class stats {

    private static Function<Double,Double> normal = a->(1/Math.sqrt(2*Calculus.pi))*Math.pow(Calculus.e, -0.5*a*a);


    public static double normalCDF(double Z, String loc){
        switch (loc) {
            case "right":
                return Math.abs(Calculus.definiteIntegral(normal, Z, Double.MAX_VALUE));
            case "center":
                return Math.abs(Calculus.definiteIntegral(normal, -1 * Z, Z));
            case "left":
                return Math.abs(Calculus.definiteIntegral(normal, -99, Z));
            default:
                System.out.println("invalid request");
                return 0;
        }
    }

    public static double normalCDF(double Z){
        return normalCDF(Z, "left");
    }


}
