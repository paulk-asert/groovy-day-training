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
import java.util.Arrays;
import java.util.function.IntFunction;

public class Main {
    public static void main(String[] args) {
        var two = 2;                                                     // Java 10
        IntFunction<Integer> twice = (final var x) -> x * two;           // Java 11
        System.out.println(twice.apply(3));
        System.out.println(twice.apply(two));

        int[] nums = {1, 2, 3};

        Integer[] result = Arrays.stream(nums)
                .boxed()
                .map(twice::apply)
                .toArray(Integer[]::new);

        System.out.println(Arrays.asList(result));
    }
}
