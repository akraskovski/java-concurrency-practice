package by.kraskovski.concurrency.basics.creature;

/**
 * Example how to create threads
 * Show main class methods to get thread info
 * <p>
 * getName() - get thread name
 * getPriority() - get thread priority
 * isAlive() - is thread running
 * join() - wait for thread end
 * run() - custom implementation to run
 * sleep() - suspend current thread to n milliseconds
 * start() - start thread
 */
public class ThreadExample extends Thread {

    public static void main(final String... args) {
        showThreadMainInfo(Thread.currentThread());
    }

    private static void showThreadMainInfo(final Thread thread) {
        System.out.println(thread.getId()); //1
        System.out.println(thread.getName()); // main
        System.out.println(thread.getPriority()); // 5
        System.out.println(thread.getState()); // RUNNABLE
        System.out.println(thread.isAlive()); // true
        System.out.println(thread.isDaemon()); // false
        System.out.println(thread.isInterrupted()); // false
    }
}
