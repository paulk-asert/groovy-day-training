import org.junit.Test

class Operators {
    @Test
    void identity() {
        def first = [1, 2, 3]
        def second = [1, 2, 3]
        def alsoFirst = first

        assert first.equals(second)
        assert first == second

        assert first.is(alsoFirst)
        assert first === alsoFirst
        assert first !== second
    }

    @Test
    void notOperators() {
        assert !('foo' instanceof Date)        // Java/Groovy 1+
        assert 'bar' !instanceof Date          // Groovy 3

        def nums = [1, 2, 3]
        assert 4 !in nums
    }

    @Test
    void elvisAssignment() {
        // Java/Groovy 1+ ternary operator
        def (a, b) = [10, null]
        a = a != null ? a : 20
        b = b != null ? b : 30
        assert a == 10 && b == 30

        // Groovy 2 Elvis operator
        def (c, d) = [100, null]
        c = c ?: 200
        d = d ?: 300
        assert c == 100 && d == 300

        // Groovy 3 Elvis assignment operator
        def (e, f) = [1000, null]
        e ?= 2000
        f ?= 3000
        assert e == 1000 && f == 3000
    }
}
