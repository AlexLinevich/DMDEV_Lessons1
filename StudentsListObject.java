package by.lav.homework66;

import java.util.List;

public class StudentsListObject {

    List<StudentShort> studentList;
    Double averageMark;

    public StudentsListObject(List<StudentShort> studentList, Double averageMark) {
        this.studentList = studentList;
        this.averageMark = averageMark;
    }

    public List<StudentShort> getStudentList() {
        return studentList;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    @Override
    public String toString() {
        return studentList +
                ", averageMark=" + averageMark +
                '}';
    }
}
