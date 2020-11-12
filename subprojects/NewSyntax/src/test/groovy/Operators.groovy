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
