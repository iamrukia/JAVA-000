package demo;

public class Fibo {
    public static long getFibo(long n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n)
                / Math.sqrt(5));
    }
}
