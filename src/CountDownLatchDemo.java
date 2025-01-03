import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor3 implements Runnable{

    private CountDownLatch latch;

    public Processor3(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
      System.out.println("Started.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        latch.countDown();
    }
}


//CountDownLatch is used to make sure that a task waits for other threads before it starts.
public class CountDownLatchDemo {

    public static void main(String[] args){

        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0; i<3; i++){
            executorService.submit(new Processor3(latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed.");
    }

}
