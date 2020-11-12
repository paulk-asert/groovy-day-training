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

import java.util.function.Function

import static java.util.Optional.empty
import static java.util.Optional.of

class StringExamples {

    @Test
    void takeBetween() {
        assert 'Groovy'.takeBetween('r', 'v') == 'oo'
    }

    @Test
    void takeBetweenWithOccurrence() {
        assert 'Groovy Gravy'.takeBetween('r', 'v', 0) == 'oo'
        assert 'Groovy Gravy'.takeBetween('r', 'v', 1) == 'a'
    }

    @Test
    void takeBefore() {
        assert 'Groovy'.takeBefore('oo') == 'Gr'
    }

    @Test
    void takeAfter() {
        assert 'Groovy'.takeAfter('oo') == 'vy'
    }

    @Test
    void startsWithIgnoreCase() {
        assert 'Groovy'.startsWithIgnoreCase('gr')
        assert 'Groovy'.startsWithIgnoreCase('GR')
    }

    @Test
    void endsWithIgnoreCase() {
        assert 'Groovy'.endsWithIgnoreCase('Vy')
        assert 'Groovy'.endsWithIgnoreCase('vY')
    }

    @Test
    void containsIgnoreCase() {
        assert 'Groovy'.containsIgnoreCase('OO')
        assert 'Groovy'.containsIgnoreCase('gR')
    }

    @Test
    void takeRight() {
        assert 'hello world'.takeRight(5) == 'world'
    }

    @Test
    void dropRight() {
        assert 'hello world'.dropRight(6) == 'hello'
    }

    @Test
    void collectReplacements() {
        // Groovy 2.1+ Closure variants
        assert 'Groovy'.collectReplacements { it == 'o' ? '_O_' : null } == 'Gr_O__O_vy'
        def replacements = [o: '_O', G: 'G_']
        assert 'Groovy'.collectReplacements { replacements[it] } == 'G_r_O_Ovy'

        // Variant using some Java 8+ Function/Optional classes
        Function<Character, Optional<String>> xform1 = s -> s == 'o' ? of('_O') : empty()
        Function<Character, Optional<String>> xform2 = { it == 'G' ? of('G_') : empty() }
        assert 'Groovy'.collectReplacements([xform1, xform2]) == 'G_r_O_Ovy'
    }
}
