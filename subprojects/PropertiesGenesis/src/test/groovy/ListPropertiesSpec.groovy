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

import static spock.genesis.Gen.*
import spock.lang.Specification

class ListPropertiesSpec extends Specification {
    def 'generate a list with size range'() {
        when: 'getting a random list of integers of a given size range'
        def list = list(integer, 1, 5).iterator().next()

        then: 'it should have the following properties'
        list instanceof List
        list.size() in 1..5
        list.every { it instanceof Integer }
    }

    def 'test list reversal'() {
        when:
        def reversed = orig.reverse()
        then:
        reversed.size() == orig.size()
        reversed.reverse() == orig
        if (orig) orig.eachWithIndex { item, i -> item == reversed[-(i + 1)] }
        where:
        orig << these([], [null]).then(list(integer)).take(10)
    }

    def 'test list shuffling'() {
        when:
        def shuffled = orig.shuffled()
        then:
        shuffled.size() == orig.size()
        shuffled.every { !it || it instanceof Integer }
        where:
        orig << these([], [null]).then(list(integer)).take(10)
    }
}
