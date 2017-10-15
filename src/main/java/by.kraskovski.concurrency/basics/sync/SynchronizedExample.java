package by.kraskovski.concurrency.basics.sync;

public class SynchronizedExample {

    public static void main(final String... args) {
        final CommonResource commonResource = new CommonResource();
        for (int count = 0; count < 5; count++) {
            new Thread(new MyRunnable(commonResource)).start();
        }
    }
}
