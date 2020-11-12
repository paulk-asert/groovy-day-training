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
