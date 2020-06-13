package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private TreeMap<T, Boolean> contents;


    public static <T> SortedSet<T> create() {
        return new SortedSet<>();
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }


    @Override
    public boolean add(T value) {
        return contents.put(value, true) == null;
    }

    @Override
    public boolean remove(Object o) {
        return contents.remove(o) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean added = false;
        for (T value : collection) {
            added = added | contents.put(value, true) == null;
        }
        return added;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean removed = false;
        for (var value : collection) {
            removed = removed | contents.remove(value) != null;
        }
        return removed;
    }

    public List<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public List<T> getReversed() {
        return new ArrayList<>(contents.descendingKeySet());
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.keySet().size();
    }

    private SortedSet() {
        this.contents = new TreeMap<>();
    }

    private SortedSet(Comparator<T> comparator) {
        this.contents = new TreeMap<>(comparator);
    }

}
