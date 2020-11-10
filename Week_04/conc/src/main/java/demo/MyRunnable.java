package demo;

public class MyRunnable implements Runnable {
    private long n;

    public MyRunnable(long n){
        this.n = n;
    }
    public void run() {
        System.out.println("使用Runnable" + Fibo.getFibo(n));
    }
}
