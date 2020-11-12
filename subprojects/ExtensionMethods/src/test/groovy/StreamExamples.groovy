import org.junit.Test

class StreamExamples {

    @Test
    void intStreamAndToArray() {
        int[] nums = [1, 2, 3]
        Integer[] expected = [2, 4, 6]

        Integer[] result = Arrays.stream(nums)
                .boxed()
                .map(i -> i * 2)
                .toArray(Integer[]::new)
        assert result == expected

        result = nums.stream()
                .map(i -> i * 2)
                .toArray(Integer)
        assert result == expected
    }
}
