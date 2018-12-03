package java.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * forkJoin实现斐波那契数列
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    long n;

    public ForkJoinDemo(long n) {
        this.n = n;
    }

    @Override
    public Long compute() {
        if (n <= 10) { // 小于10不再分解
            return ForkJoinDemo.calc(n);
        }
        ForkJoinDemo f1 = new ForkJoinDemo(n - 1); // 分解出计算n-1斐波那契数的子任务
        f1.fork(); // 由ForkJoinPool分配线程执行子任务
        ForkJoinDemo f2 = new ForkJoinDemo(n - 2); // 分解出计算n-2斐波那契数的子任务
        f2.fork();
        return f2.join() + f1.join();
//        return f2.compute() + f1.join();
    }

    public static long calc(long n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return n;
        } else {
            return calc(n - 1) + calc(n - 2);
        }
    }

    public static void main(String[] args) {
        long n = 40;
        long begin = System.nanoTime();
        ForkJoinDemo FibTask = new ForkJoinDemo(n);
        ForkJoinPool pool = new ForkJoinPool();
        long f = pool.invoke(FibTask);
        long end = System.nanoTime();
        System.out.println("第" + n + "个斐波那契数是" + f + ", 耗时" + TimeUnit.NANOSECONDS.toMillis(end - begin) + "毫秒");
    }

}