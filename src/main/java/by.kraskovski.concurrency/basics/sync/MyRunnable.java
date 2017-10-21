package by.kraskovski.concurrency.basics.sync;

/**
 * Synchronized {@link CommonResource} class.
 * <p>
 * Creates monitor, so any thread will wait while
 * current thread finish job ang go to dead state.
 */
public class MyRunnable implements Runnable {
    private final CommonResource commonResource;

    public MyRunnable(final CommonResource commonResource) {
        this.commonResource = commonResource;
    }

    @Override
    public void run() {
        synchronized (commonResource) {
            for (int count = 0; count < 3; count++) {
                commonResource.increment();
                System.out.printf("Thread: %s. Counter: %d%n", Thread.currentThread().getName(), commonResource.getCounter());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
