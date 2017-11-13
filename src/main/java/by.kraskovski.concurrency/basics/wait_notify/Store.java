package by.kraskovski.concurrency.basics.wait_notify;

public class Store {

    private int item = 0;

    public synchronized void getItem() throws InterruptedException {
        while (item < 1) {
            wait();
            Thread.sleep(1000);
        }
        item--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + item);
        notify();
    }

    public synchronized void putItem() throws InterruptedException {
        while (item >= 5) {
            wait();
            Thread.sleep(1000);
        }
        item++;
        Thread.sleep(1000);
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + item);
        notify();
    }
}
