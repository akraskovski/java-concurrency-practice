package by.kraskovski.concurrency.basics.sync;

public class SynchronizedExample {
    private int counter = 0;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(final String... args) {
        final SynchronizedExample synchronizedExample = new SynchronizedExample();
        for (int count = 0; count < 5; count++) {
            new Thread(new MyRunnable(synchronizedExample)).start();
        }
    }
}
