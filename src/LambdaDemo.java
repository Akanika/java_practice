import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaDemo {

    public static void main(String[] args){
        streamDemo();
        collectDemo();
        parallelStream();
        System.out.println(" " + workaroundSingleThread());
    }

    public static int workaroundSingleThread() {
        int[] holder = new int[] { 2 };
        IntStream sums = IntStream
                .of(1, 2, 3)
                .map(val -> val + holder[0]);

        holder[0] = 0;

        return sums.sum();
    }

    public static void streamDemo(){
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();

        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("a, b, c");

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().count();

        Optional<String> stream = list.stream().filter(element -> {
            return element.contains("2");
        }).map(element -> {
            return element.toUpperCase();
        }).findFirst();

        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    return a + b;
                });

        System.out.println(stream);
    }


    public static void collectDemo(){
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        List<String> collectorCollection =
                productList.stream().map(Product::getName).collect(Collectors.toList());

        String listToString = productList.stream().map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedListOfPersons =
                productList.stream().collect(toLinkedList);

        System.out.println(listToString);
    }

    public static void parallelStream(){
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel();
        boolean bigPrice = streamOfCollection
                .map(product -> product.getId() * 12)
                .anyMatch(id -> id > 200);

        Stream<String> stream = Stream.of("a", "aa", "aaa", "aaaaa")
                .dropWhile(s -> s.length() < 5);

        System.out.println(bigPrice);
    }


}

class Product{
    int id;
    String productName;

    Product(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public String getName(){
        return productName;
    }

    public int getId(){
        return id;
    }

}
