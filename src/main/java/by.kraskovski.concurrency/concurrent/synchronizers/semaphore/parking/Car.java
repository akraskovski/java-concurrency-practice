package by.kraskovski.concurrency.concurrent.synchronizers.semaphore.parking;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {

    private static final int PARKING_PLACES_COUNT = 5;
    private static final boolean[] PARKING_PLACES = new boolean[PARKING_PLACES_COUNT];
    private static final Semaphore SEMAPHORE = new Semaphore(PARKING_PLACES_COUNT, true);

    private final int carNumber;

    public Car(final int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.printf("The car №%d drove up to the parking%n", carNumber);
        try {
            SEMAPHORE.acquire();
            int parkingNumber = -1;
            synchronized (PARKING_PLACES) {
                for (int i = 0; i < 5; i++)
                    if (!PARKING_PLACES[i]) {
                        PARKING_PLACES[i] = true;
                        parkingNumber = i;
                        System.out.printf("The car №%d has parked at the place %d.\n", carNumber, i);
                        break;
                    }
            }

            Thread.sleep(5000);

            synchronized (PARKING_PLACES) {
                PARKING_PLACES[parkingNumber] = false;
            }

            SEMAPHORE.release();
            System.out.printf("The car №%d has left the parking.\n", carNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
