import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) throws Exception{
//        Semaphore sem = new Semaphore(1);
//        sem.release();
//        sem.acquire();
//        System.out.println("Available permits: " + sem.availablePermits());


        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<200;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection{

    private  static Connection instance = new Connection();

    private int connections  = 0;

    private Semaphore sem = new Semaphore(10);

    private Connection(){

    }

    public static Connection getInstance(){
        return instance;
    }

    public void connect(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try{
            doConnect();
        }
        finally {
            sem.release();
        }
    }



    public void doConnect(){

        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this){
            connections++;
            System.out.println("Current connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this){
            connections--;
        }

        sem.release();
    }
}
