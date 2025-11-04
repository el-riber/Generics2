package genericsadvanced;

import java.util.*;
import java.util.function.Function;

public class Cache<T> {
    private final Map<String, T> store = new LinkedHashMap<>();
    private final Function<? super T, String> keyExtractor;

    public Cache(Function<? super T, String> keyExtractor) {
        if (keyExtractor == null) throw new IllegalArgumentException("keyExtractor cannot be null");
        this.keyExtractor = keyExtractor;
    }

    public void add(T item) {
        String key = keyExtractor.apply(item);
        if (key == null) throw new IllegalArgumentException("keyExtractor returned null");
        store.put(key, item);
    }

    public Optional<T> get(String key) {
        return Optional.ofNullable(store.get(key));
    }

    public boolean containsKey(String key) {
        return store.containsKey(key);
    }

    public void clear() {
        store.clear();
    }

    public int size() {
        return store.size();
    }

    public Collection<T> values() {
        return Collections.unmodifiableCollection(store.values());
    }

    /**
     * addAll from one cache to another (compatible types).
     * Accept any Cache whose T is a subtype of our T.
     */
    public void addAll(Cache<? extends T> other) {
        for (T item : other.values()) {
            add(item);
        }
    }

    @Override
    public String toString() {
        return store.values().toString();
    }
}
