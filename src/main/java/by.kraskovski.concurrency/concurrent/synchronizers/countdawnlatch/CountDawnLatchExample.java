package by.kraskovski.concurrency.concurrent.synchronizers.countdawnlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Example of using {@link java.util.concurrent.CountDownLatch}
 */
public class CountDawnLatchExample {

    public static void main(final String... args) throws InterruptedException {
        final int invokeTimes = 3;
        final CountDownLatch countDownLatch = new CountDownLatch(invokeTimes);

        System.out.println(Thread.currentThread().getName() + " was stared");

        for (int counter = 0; counter < invokeTimes; counter++) {
            new Work(countDownLatch);
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
