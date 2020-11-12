/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
