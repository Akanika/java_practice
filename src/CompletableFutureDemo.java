import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> greetingFuture
                = CompletableFuture.supplyAsync(() -> {
            // some async computation
            return "Hello from CompletableFuture";
        });

        CompletableFuture<String> firstNameFuture
                = CompletableFuture.supplyAsync(() -> "Kanika");
        CompletableFuture<String> LastNameFuture
                = CompletableFuture.supplyAsync(() -> "Avasthi");

        CompletableFuture<String> combinedFuture
                = firstNameFuture.thenCombine(
                LastNameFuture, (m1, m2) -> m1 + " " + m2);

        CompletableFuture<Integer> resultFuture
                // java.lang.ArithmeticException: / by zero
                = CompletableFuture.supplyAsync(() -> 2 / 0)
                .exceptionally(ex -> 0);

        System.out.println(resultFuture.get());


        int array[] = {1, 2, 6, 3,  4,  5,  6,
                7, 8, 9, 10, 11, 12, 6, 11, 2, 3 };

        int searchElement = 11;
        int start = 0;
        int end = array.length - 1;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        SearchTask task = new SearchTask(array, start, end,
                searchElement);
        int result = pool.invoke(task);
        System.out.println(searchElement + " found "
                + result + " times ");
    }
}

class SearchTask extends RecursiveTask<Integer>{

    int array[];
    int start,end;
    int searchElement;

    public SearchTask(int array[], int start, int end, int searchElement){
        this.array = array;
        this.start = start;
        this.end = end;
        this.searchElement = searchElement;
    }

    @Override
    protected Integer compute() {
        return processSearch();
    }

    private Integer processSearch(){
        int count = 0;
        for(int i = start; i<=end; i++){
            if(array[i] == searchElement){
                count++;
            }
        }

        return count;
    }
}
