import org.junit.Test

class Loops {
    @Test
    void doWhile() {
        def count = 5
        def fact = 1
        do {
            fact *= count--
        } while (count > 1)
        assert fact == 120
    }

    @Test
    void enhancedClassicForLoop() {
        def facts = []
        def count = 5
        for (int fact = 1, i = 1; i <= count; i++, fact *= i) {
            facts << fact
        }
        assert facts == [1, 2, 6, 24, 120]
    }
}
