import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Runner extends Thread{
    @Override
    public void run() {

        for(int i=0;i<10;i++){
            System.out.println("Hello " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Runner1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Hello " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Processor extends Thread{

    private volatile boolean running = true;

    @Override
    public void run() {

        while(running){
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown(){
        running = false;
    }
}

class Processor1 implements Runnable{

    private int id;

    public Processor1(int id){
        this.id = id;
    }

    @Override
    public void run() {
      System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed: " + id);
    }
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {
//       Runner runner1 = new Runner();
//       runner1.start();
//
//        Runner runner2 = new Runner();
//        runner2.start();

//        Thread t1 = new Thread(new Runner1());
//        Thread t2 = new Thread(new Runner1());
//
//        t1.start();
//        t2.start();

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<10;i++){
//                    System.out.println("Hello " + i);
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        });
//
//        t1.start();

//        Processor proc1 = new Processor();
//        proc1.start();
//
//        System.out.println("Press return to stop...");
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
//
//        proc1.shutdown();

//        Main main = new Main();
//        main.doWork();

      //  new Worker().main();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i=0;i<5;i++){
            executorService.submit(new Processor1(i));
        }

        executorService.shutdown();
        System.out.println("All tasks submitted.");

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks completed.");
    }


    public void doWork()  {
      Thread t1 = new Thread(new Runnable() {
          @Override
          public void run() {

            for(int i=0; i<10000;i++){
                increment();
            }

          }
      });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i<10000;i++){
                    increment();
                }

            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Count is: " + count);
    }
}
