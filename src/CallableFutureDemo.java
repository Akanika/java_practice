import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureDemo {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();

//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                Random random = new Random();
//                int duration = random.nextInt(4000);
//
//                System.out.println("Starting...");
//
//                try {
//                    Thread.sleep(duration);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//
//                System.out.println("Finished.");
//            }
//        });

        Future<Integer> future =  executorService.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                if(duration > 2000){
                    throw new IOException("Sleeping for too long.");
                }

                System.out.println("Starting...");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Finished.");
                return duration;
            }
        });

        executorService.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
