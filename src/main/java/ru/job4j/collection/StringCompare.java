package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < left.length(); i++) {
            char l = left.charAt(i);
            char r = right.charAt(i);
            int cmp = Character.compare(l, r);
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}