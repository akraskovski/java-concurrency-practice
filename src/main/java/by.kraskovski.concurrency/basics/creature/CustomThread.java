package by.kraskovski.concurrency.basics.creature;

public class CustomThread extends Thread {

    @Override
    public void run() {
        System.out.printf("Custom thread %s start working... \n", Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.printf("Custom thread %s stop working... \n", Thread.currentThread().getName());
    }
}
