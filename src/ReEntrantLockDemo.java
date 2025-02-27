import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockDemo {

    public static void main(String[] args) throws InterruptedException {
       Runner2 runner2 = new Runner2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   runner2.firstThread();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner2.secondThread();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner2.finished();
    }

}


class Runner2{
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment(){
        for(int i=0;i<10000;i++){
            count++;
        }
    }

    public void firstThread() throws InterruptedException{
        lock.lock();

        System.out.println("Waiting....");
        cond.await();

        System.out.println("Woken up!");

        try {
            increment();

        }
        finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException{
        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key!");

        cond.signal();

        try {
            increment();
        }
        finally {
            lock.unlock();
        }
    }

    public void finished(){
        System.out.println("Count is:  " + count);
    }
}
