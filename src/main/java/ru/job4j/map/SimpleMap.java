package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        modCount++;
        count++;
        if (count > table.length * LOAD_FACTOR) {
            expand();
        }
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        boolean rsl = table[index] == null;
        if (rsl) {
            table[index] = new MapEntry<>(key, value);
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 8);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
        MapEntry<K, V>[] temp = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        for (var mapEntry : temp) {
            if (mapEntry != null) {
                int index = mapEntry.getKey() == null ? 0 : indexFor(hash(mapEntry.getKey().hashCode()));
                table[index] = mapEntry;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        return table[index] == null ? null : table[index].getValue();
    }

    @Override
    public boolean remove(K key) {
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        boolean rsl = false;
        modCount++;
        if (table[index] != null) {
            table[index] = null;
            rsl = true;
            count--;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int index = 0;
            int modIterator = modCount;
            @Override
            public boolean hasNext() {
                if (modIterator != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean rsl = index  < table.length;
                if (!rsl) {
                    return false;
                } else if (table[index] == null) {
                    index++;
                    return hasNext();
                } else {
                    return true;
                }
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].getKey();
            }
        };
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
