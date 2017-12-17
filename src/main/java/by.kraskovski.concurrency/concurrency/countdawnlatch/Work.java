package by.kraskovski.concurrency.concurrency.countdawnlatch;

import java.util.concurrent.CountDownLatch;

public class Work extends Thread {

    private final CountDownLatch countDownLatch;

    public Work(final CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished work");
        countDownLatch.countDown();
    }
}
