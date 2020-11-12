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

import spock.lang.Specification

class ListExamplesSpec extends Specification {
    def "Scenario #scenario: #orig reversed should be #reversed"() {
        expect:
        orig.reverse() == reversed

        where:
        scenario              | orig      || reversed
        'empty'               | []        || []
        'singleton'           | [null]    || [null]
        'singleton with null' | [1]       || [1]
        'standard'            | [1, 2, 3] || [3, 2, 1]
    }

    def 'test list reversal'() {
        given:
        def orig = [1, 2, 3]
        when:
        def reversed = orig.reverse()
        then:
        reversed.size() == orig.size()
        reversed.reverse() == orig
        reversed == [3, 2, 1]
    }

    def 'test list shuffling'() {
        given:
        def orig = [1, 2, 3]
        when:
        def shuffled = orig.shuffled()
        then:
        shuffled.size() == orig.size()
        shuffled.every { it in orig }
    }
}
