package stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamTest {
    public static void main(String[] args) {

//        mapOperation();
//        peekOperation();
        generateStream();
    }

    public static void createStream() {
        Stream stream = Stream.of("a", "b", "c");

        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

        IntStream.of(1, 2, 3).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

    }

    public static void convertStreamToStructure() {
        // Array
        Stream<String> stream = Stream.of("a", "b", "c");
        String[] strArray = stream.toArray(String[]::new);

        // Collection
        List<String> listArray = stream.collect(Collectors.toList());
        List<String> listArr = stream.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = stream.collect(Collectors.toSet());
        Stack stack = stream.collect(Collectors.toCollection(Stack::new));

        //
        String str = stream.collect(Collectors.joining());
    }

    public static void mapOperation() {
        Stream.of("hello", "world", "good").map(String::toUpperCase).forEach(System.out::println);
        IntStream.of(1, 2, 3).map(e -> e * e).forEach(System.out::println);

        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        listStream.flatMap((child) -> child.stream()).forEach(System.out::println);

    }

    public static void peekOperation() {
        Stream.of("one", "two", "three", "four").filter(e -> e.length()>3)
                .peek(e -> System.out.println("Filtered value " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value " + e))
                .forEach(System.out::println);


    }

    public static void reduceOperation() {
        String concat = Stream.of("a", "b", "c", "d").reduce("", String::concat);
        double minValue = Stream.of(-3.0, -1.0, 5.0, 4.0).reduce(Double.MAX_VALUE, Double::min);
        int sumValue = Stream.of(1, 2, 3).reduce(0, Integer::sum);
        sumValue = Stream.of(4, 5, 6).reduce(Integer::sum).get();
    }

    public static void generateStream() {
        Random random = new Random();
        Supplier<Integer> randomInt = random::nextInt;
        Stream.generate(randomInt).limit(10).forEach(e -> System.out.print(" " + e));

        IntStream.generate(() -> (int)(System.nanoTime()%100)).limit(10).forEach(e -> System.out.print(" " + e));

        Stream.iterate(0, x -> x + 3).limit(10).forEach(e -> System.out.print(" " + e));
    }
}
