package com.br.desafiopokeapi.cache;

import java.util.Optional;

public interface GenericCache<K, V> {

    void clean();

    void clear();

    boolean containsKey(K key);

    Optional<V> get(K key);

    void put(K key, V value);

    void remove(K key);
}
