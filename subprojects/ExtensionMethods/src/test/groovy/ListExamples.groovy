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
