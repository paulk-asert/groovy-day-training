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
