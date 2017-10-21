package by.kraskovski.concurrency.basics.sync.statics;

/**
 * Synchronized {@link CommonStaticResource} class.
 * <p>
 * Creates monitor, so any thread will wait while
 * current thread finish job ang go to dead state.
 */
public class CommonStaticResource {
    private static int counter = 0;

    public synchronized static void increment() {
        System.out.printf("Start increment. Thread: %s. Counter: %d%n", Thread.currentThread().getName(), counter);
        CommonStaticResource.counter++;
        System.out.printf("Finish increment. Thread: %s. Counter: %d%n", Thread.currentThread().getName(), counter);
    }

//    Equivalent method to previous one.
//    public static void increment() {
//        synchronized (CommonStaticResource.class) {
//            System.out.printf("Start increment. Thread: %s. Counter: %d%n", Thread.currentThread().getName(), counter);
//            CommonStaticResource.counter++;
//            System.out.printf("Finish increment. Thread: %s. Counter: %d%n", Thread.currentThread().getName(), counter);
//        }
//    }
}
