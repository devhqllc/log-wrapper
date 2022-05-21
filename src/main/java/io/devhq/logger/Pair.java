package io.devhq.logger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<K, V> {
    private K key;
    private V value;

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    @Override
    public String toString() {
        return String.format("%s:%s", key, value);
    }


}
