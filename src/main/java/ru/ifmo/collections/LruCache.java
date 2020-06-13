package ru.ifmo.collections;

import java.util.*;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    HashMap<K, V> hashMap = new HashMap();
    HashSet<K> hashSet = new HashSet<>();
    LinkedList<K> linkedList = new LinkedList<>();
    int capacity;

    public V get(K key) {
        if (hashSet.contains(key)) {
            linkedList.remove(key);
            linkedList.add(key);
        }
        return hashMap.get(key);
    }


    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        if (hashSet.size() >= capacity) {
            K removeKey = linkedList.getFirst();
            linkedList.remove(removeKey);
            hashSet.remove(removeKey);
            hashMap.remove(removeKey);

        }
        hashMap.put(key, value);
        hashSet.add(key);
        linkedList.add(key);
    }

    public int elements() {
        return hashMap.size();
    }
}