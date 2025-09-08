import java.util.*;

interface SearchEngine {
    List<String> index(String path);
    List<String> query(String q);
    void warmupCache();
    void rebuildAll();
}

class AutocompleteService {
    private final SearchEngine engine;
    AutocompleteService(SearchEngine engine){ this.engine = engine; }
    List<String> suggest(String prefix) {
        engine.warmupCache(); // legacy: side-effect not needed here
        return engine.query(prefix + "*");
    }
}
