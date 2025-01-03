import java.util.Scanner;

public class ProducerConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        Processor4 processor4 = new Processor4();
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
 class Processor4{
    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Procedure thread running...");
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(5000);
        }
    }
}
