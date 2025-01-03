import java.util.Random;
import java.util.concurrent.*;

public class InterruptingThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting..");

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> fu = exec.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Random ran = new Random();

                for(int i=0;i<1E8;i++){

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }

                    Math.sin(ran.nextDouble());
                }
                return null;
            }
        });


//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Random ran = new Random();
//
//                for(int i=0;i<1E8;i++){
//
//                    if(Thread.currentThread().isInterrupted()){
//                        System.out.println("Interrupted!");
//                        break;
//                    }
//
//                    Math.sin(ran.nextDouble());
//                }
//            }
//        });
//        t.start();
//        Thread.sleep(500);
//        t.interrupt();
//        t.join();

        exec.shutdown();
        Thread.sleep(500);
        fu.cancel(true);
        exec.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Finished.");
    }

}
