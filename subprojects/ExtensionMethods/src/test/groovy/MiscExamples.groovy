import org.junit.Test

import java.time.LocalDate
import java.time.Month

class MiscExamples {

    @Test
    void minusForLocalDate() {
        def xmas = LocalDate.of(2020, Month.DECEMBER, 25)
        def newYear = LocalDate.of(2021, Month.JANUARY, 1)
        assert newYear - xmas == 7
    }

}
