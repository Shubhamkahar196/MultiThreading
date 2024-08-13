
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {

    private final Lock unfairLock = new ReentrantLock();

    public void accessResources() {
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            unfairLock.unlock();
            System.err.println(Thread.currentThread().getName() + " released the lock ");
        }
    }

    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResources();
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

}
