
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();   // object of lock and lock is interface

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "attempting to draw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdraw ");
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdraw , Raimaing Balance : " + balance);
                    } catch (Exception e) {
                    } finally {
                        lock.unlock();
                    }

                } else {
                    System.out.println(Thread.currentThread().getName() + "insufficient balance ");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock , will try later ");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().interrupt()){
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
