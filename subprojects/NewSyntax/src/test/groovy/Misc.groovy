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

class Misc {
    @Test
    void safeNavigation() { // Groovy 1+
        def (a, b) = ['foo', null]
        assert a?.size() == 3
        assert b?.size() == null   // but no NPE thrown
    }

    @Test
    void safeIndexingForList() {
        def as = ['foo', 'bar']
        def bs = null
        assert as?[0] == 'foo'
        assert bs?[0] == null
    }

    @Test
    void safeIndexingForArray() {
        String[] as = ['foo', 'bar']
        String[] bs = null
        assert as?[0] == 'foo'
        assert bs?[0] == null
    }

    @Test
    void safeIndexingForMap() {
        def as = [foo: 10, bar: 20]
        def bs = null
        assert as?['foo'] == 10
        assert bs?['anything'] == null
    }
}
