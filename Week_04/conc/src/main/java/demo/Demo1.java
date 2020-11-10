package demo;

import java.util.concurrent.*;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        long result1 = 0;
        final long[] mutable = new long[2];
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        // 1st - use Callable
        MyCallable myCallable = new MyCallable(10);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Long> future = executorService.submit(myCallable);


        // 确保  拿到result 并输出
        result1 = future.get();
        System.out.println("异步计算结果为：" + result1);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 2nd one - use Runnable
        start = System.currentTimeMillis();
        Runnable r = new Runnable() {
            public void run() {
                mutable[0] = Fibo.getFibo(10);
            }
        };
        Future<long[]> future1 = executorService.submit(r, mutable);
        long[] result2 = future1.get();
        System.out.println("异步计算结果为：" + result2[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 3rd one - use future task
        start = System.currentTimeMillis();
        FutureTask<Long> futureTask = new FutureTask<Long>(new MyCallable(10));
        executorService.submit(futureTask);
        long result3 = futureTask.get();
        System.out.println("异步计算结果为：" + result3);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

    // 然后退出main线程

        executorService.shutdown();
}
}
