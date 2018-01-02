package by.kraskovski.concurrency.concurrent.executors.callable;

import java.util.concurrent.Callable;

/**
 * Callable is simple interface, similar with {@link Runnable}
 * but with possibility to return Objects and thrown Exceptions.
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable is running and sleep to 2 seconds");
        Thread.sleep(2000);
        return Thread.currentThread().getName();
    }
}
