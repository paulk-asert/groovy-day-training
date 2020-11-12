import org.junit.Test

class ListExamples {

    @Test
    void average() {
        assert 15 == [10, 20].average()
    }

    @Test
    void shuffledAndShuffle() {
        // shuffled() leaves original untouched and produces a shuffled copy
        def permuted = (1..10).shuffled()
        assert permuted.size() == 10
        assert permuted.each { i -> i in 1..10 }

        // shuffle() mutates the receiver permuting the items
        def nums = [10, 20, 30, 40]
        boolean shuffled = false
        int count = 0
        while (!shuffled && count++ < 5) {
            nums.shuffle()
            if (nums.head() != 10) shuffled = true
        }
        assert shuffled
    }
}
