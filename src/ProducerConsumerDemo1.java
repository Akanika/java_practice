import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Processor5 processor4 = new Processor5();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor4.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor4.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}

class Processor5{

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException{
        int value = 0;

        while (true){

            synchronized (lock) {

                while(list.size() == LIMIT){
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException{

        Random random = new Random();

        while (true){
            synchronized (lock) {

                while(list.size() == 0){
                    lock.wait();
                }

                System.out.println("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }

            Thread.sleep(random.nextInt(1000));
        }
    }
}
