package by.kraskovski.concurrency.basics.sync;

public class MyRunnable implements Runnable {
    private final SynchronizedExample synchronizedExample;

    public MyRunnable(final SynchronizedExample synchronizedExample) {
        this.synchronizedExample = synchronizedExample;
    }

    @Override
    public void run() {
        synchronized (synchronizedExample) {
            for (int count = 0; count < 5; count++) {
                synchronizedExample.increment();
                System.out.printf("Thread: %s. Counter: %d%n", Thread.currentThread().getName(), synchronizedExample.getCounter());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
