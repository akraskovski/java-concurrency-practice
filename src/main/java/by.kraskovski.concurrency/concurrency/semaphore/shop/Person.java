package by.kraskovski.concurrency.concurrency.semaphore.shop;

import java.util.concurrent.Semaphore;

/**
 * Custom {@link Thread} implementation with person queue in store.
 */
public class Person extends Thread {

    private final Semaphore cashbox;

    Person(final Semaphore cashbox) {
        this.cashbox = cashbox;
    }

    @Override
    public void run() {
        System.out.printf("%s waiting for order in shop%n", this.getName());
        try {
            cashbox.acquire();
            System.out.println(this.getName() + " buying products");
            Thread.sleep(2000);
            cashbox.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
