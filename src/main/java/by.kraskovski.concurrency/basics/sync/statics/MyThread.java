package by.kraskovski.concurrency.basics.sync.statics;

public class MyThread extends Thread {

    @Override
    public void run() {
        CommonStaticResource.increment();
    }
}
