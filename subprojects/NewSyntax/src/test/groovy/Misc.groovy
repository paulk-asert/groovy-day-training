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
