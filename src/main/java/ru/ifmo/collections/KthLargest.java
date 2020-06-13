package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private List<Integer> Array = new LinkedList<>();
    private int k;

    public KthLargest(int k, int[] numbers) {
        for(int i = 0; i < numbers.length; i++)
            Array.add(numbers[i]);

        this.k = k;
    }

    public int add(int val) {
        Array.add(val);
        Array.sort(Collections.reverseOrder());
        return Array.get(k-1);
    }
}