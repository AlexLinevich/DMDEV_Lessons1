package by.lav.homework66;

import java.util.Comparator;

public class StudentShortSortedByFullName implements Comparator<StudentShort> {

    @Override
    public int compare(StudentShort o1, StudentShort o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
