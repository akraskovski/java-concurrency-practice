package by.kraskovski.concurrency.basics.volatile_var;

/**
 * Can be used with variables. Don't use cache.
 * <p>
 * By default copies of local variables stores in heap for every thread.
 * Volatile variable tells threads to call general copy of variable to get value.
 * Keyword volatile do following:
 * - guarantied that first will be write operations, then read
 * - only read/write operations are atomic!
 * - increment and decrement are not synchronized! i++ i--
 * - the value of variable can be used safely by every thread
 */
public class VolatileExample {

    private static volatile int variable = 0;

    public static void main(final String... args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = variable;
            while (local_value < 5) {
                if (local_value != variable) {
                    System.out.println("Got Change for variable : " + variable);
                    local_value = variable;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int local_value = variable;
            while (variable < 5) {
                System.out.println("Incrementing variable to : " + variable);
                variable = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
