package by.kraskovski.concurrency.basics.sync;

/**
 * Example of synchronized operator using.
 * <p>
 * Illustrates monitor working: other threads will wait
 * while current finishes his work.
 */
public class SynchronizedExample {

    public static void main(final String... args) {
        final CommonResource commonResource = new CommonResource();
        new Thread(new MyRunnable(commonResource)).start();
        new Thread(new MyRunnable(commonResource)).start();
    }
}
