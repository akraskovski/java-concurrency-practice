package by.kraskovski.concurrency.basics.creature.thread;

/**
 * Example how to create threads using {@link Thread} implementation.
 */
public class ThreadExample extends Thread {

    public static void main(final String... args) {
        System.out.println("Main thread is start working...");

        customThreadExample();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is stop working...");
    }

    private static void customThreadExample() {
//        new CustomThread().run(); // if use run() thread will join to "main" thread.
        new CustomThread().start(); // start work in another thread
    }
}
