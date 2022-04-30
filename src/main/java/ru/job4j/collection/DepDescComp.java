package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (Character.compare(o1.charAt(0), o2.charAt(0)) == 0 && Character.compare(o1.charAt(1), o2.charAt(1)) == 0) {
            for (int i = 1; i < Math.min(o1.length(), o2.length()); i++) {
                if (Character.compare(o1.charAt(o1.length() - i), o2.charAt(o2.length() - i)) != 0) {
                    break;
                }
            }
            return o1.compareTo(o2);
        }
        return o2.compareTo(o1);
    }
}
