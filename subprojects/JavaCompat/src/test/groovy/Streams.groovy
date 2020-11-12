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
import java.util.stream.Collectors

class Streams {

    @Test
    void streams() {
        def two = 2
        def twice = { x -> x * two }
        def nums = [1, 2, 3]
        def expectedTwice = [2, 4, 6]

        assert expectedTwice == nums.collect { i -> twice.call(i) }
        assert expectedTwice == nums.collect { twice(it) }
        assert expectedTwice == nums.stream()
                                    .map { i -> twice(i) }
                                    .collect(Collectors.toList())
        assert expectedTwice == nums.stream().map { twice(it) }.toList()

        assert expectedTwice == nums.collect(twice::call)
        assert expectedTwice == nums.stream().map(twice::call).toList()
        assert expectedTwice as Integer[] == nums.stream().map(twice::call).toArray(Integer[]::new)
        assert expectedTwice as Integer[] == nums.stream().map(twice::call).toArray(Integer)

        var three = 3
        IntFunction<Integer> thrice = (final var x) -> x * three
        def expectedThrice = [3, 6, 9]

        assert expectedThrice == nums.collect(thrice::apply)
        assert expectedThrice == nums.collect(i -> thrice(i))
        assert expectedThrice == nums.collect(i -> thrice.apply(i))
        assert expectedThrice == nums.collect { i -> thrice.apply(i) }
        assert expectedThrice == nums.collect { i -> thrice(i) }
        assert expectedThrice == nums.collect { thrice(it) }

        assert expectedThrice == nums.stream().map(thrice::apply).toList()
        assert expectedThrice == nums.stream().map(i -> thrice.apply(i)).toList()
        assert expectedThrice == nums.stream().map(i -> thrice(i)).toList()
        assert expectedThrice == nums.stream().map { i -> thrice.apply(i) }.toList()
        assert expectedThrice == nums.stream().map { i -> thrice(i) }.toList()
        assert expectedThrice == nums.stream().map { thrice(it) }.toList()
    }


}
