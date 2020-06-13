package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private HashMap<Integer, Integer> AllInts = new HashMap<>();
    private ArrayList<Integer> Uniques = new ArrayList<>();

    public FirstUnique(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            if(AllInts.get(numbers[i]) == null)
                AllInts.put(numbers[i], 0);
            else
                AllInts.put(numbers[i], 1);
        }

        for(int i = 0; i < numbers.length; i++){
            if(AllInts.get(numbers[i]) == 0)
                Uniques.add(numbers[i]);
        }

    }

    public int showFirstUnique() {
        if(Uniques == null || Uniques.size() == 0)
            return -1;
        else
            return Uniques.get(0);
    }

    public void add(int value) {
        if(AllInts.get(value) == null) {
            AllInts.put(value, 0);
            Uniques.add(value);
        }
        else {
            AllInts.put(value, 1);
            for(int i = 0; i < Uniques.size(); i++) {
                if(Uniques.get(i) == value)
                    Uniques.remove(i);
            }
        }
    }
}
