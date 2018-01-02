package by.kraskovski.concurrency.concurrent.executor_services.schedule;

import by.kraskovski.concurrency.concurrent.executors.callable.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Example of usage {@link java.util.concurrent.ScheduledExecutorService}.
 */
public class ScheduleExample {

    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        final FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        scheduledExecutorService.schedule(futureTask, 5, TimeUnit.SECONDS);

        try {
            System.out.printf("Thread: %s has finished.%n", futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            scheduledExecutorService.shutdown();
        }
    }
}
