package by.kraskovski.concurrency.basics.sync;

public class MyRunnable implements Runnable {
    private final CommonResource commonResource;

    public MyRunnable(final CommonResource commonResource) {
        this.commonResource = commonResource;
    }

    @Override
    public void run() {
        synchronized (commonResource) {
            for (int count = 0; count < 5; count++) {
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
