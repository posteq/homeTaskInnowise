package by.innowise.tkachuk.comparator;

import by.innowise.tkachuk.entity.CustomArray;

import java.util.Comparator;

public class LenghtComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return Integer.compare(o1.getLength(), o2.getLength());
    }
}
