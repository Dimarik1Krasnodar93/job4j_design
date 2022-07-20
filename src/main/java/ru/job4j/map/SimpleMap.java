package ru.job4j.map;

import java.sql.Array;
import java.util.Iterator;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = true;
        if (count >= table.length * LOAD_FACTOR) {
            expand();
            rsl = false;
        }
        int index = indexFor(hash(key.hashCode()));
        table[index] = new MapEntry<>(key, value);
        count++;
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> capacity); // побитовый сдвиг вправо. Но что значит >>> не понял
        //да и зачем все это. для целей хэшмэпа достаточно просто взять как в уроке написано Метод деления и получить баскет.
        ///зачем все эти сложности, не понимаю
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
        MapEntry<K, V>[] temp = table;
        capacity *= 2;
        MapEntry<K, V>[] table = new MapEntry[capacity];
        for (var mapEntry : table ) {
            if (mapEntry != null) {
                int index = indexFor(hash(mapEntry.getKey().hashCode()));
                table[index] = mapEntry;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));
        return table[index] == null ? null : table[index].getValue();
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        boolean rsl = false;
        if (table[index] != null) {
            table[index] = null;
            rsl = true;
            count--;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
