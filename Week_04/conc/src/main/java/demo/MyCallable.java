package demo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {
    private long n;

    public MyCallable (long n){
        this.n = n;
    }
    public Long call() throws Exception {
        return Fibo.getFibo(n);
    }
}
