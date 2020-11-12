import org.junit.Test

import java.util.function.IntFunction

class Misc {
    @Test
    void var() {
        // Closure Groovy 1+
        def two = 2
        def twice = { x -> x * two }
        assert 6 == twice.call(3)
        assert 4 == twice(two)

        // Lambdas and var
        var three = 3                                                    // Java 10
        IntFunction<Integer> thrice = (final var x) -> x * three         // Java 11
        assert 6 == thrice.apply(two)
        assert 9 == thrice(three)
    }
}
