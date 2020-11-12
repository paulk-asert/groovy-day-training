import java.util.Arrays;
import java.util.function.IntFunction;

public class Main {
    public static void main(String[] args) {
        var two = 2;                                                     // Java 10
        IntFunction<Integer> twice = (final var x) -> x * two;           // Java 11
        System.out.println(twice.apply(3));
        System.out.println(twice.apply(two));

        int[] nums = {1, 2, 3};

        Integer[] result = Arrays.stream(nums)
                .boxed()
                .map(twice::apply)
                .toArray(Integer[]::new);

        System.out.println(Arrays.asList(result));
    }
}
