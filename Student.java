package by.lav.homework66;

import java.util.List;
import java.util.Objects;

/**
 * Дан список студентов с полями:
 * * - Имя
 * * - Фамилия
 * * - Номер курса в университете
 * * - Список оценок за учебу
 */
public class Student {

    String name;
    String surname;
    int cursNumber;
    List<Integer> marksList;

    public Student(String name, String surname, int cursNumber, List<Integer> marksList) {
        this.name = name;
        this.surname = surname;
        this.cursNumber = cursNumber;
        this.marksList = marksList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getCursNumber() == student.getCursNumber() &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getSurname(), student.getSurname()) &&
                Objects.equals(getMarksList(), student.getMarksList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getCursNumber(), getMarksList());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public int getCursNumber() {
        return cursNumber;
    }

    public List<Integer> getMarksList() {
        return marksList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cursNumber=" + cursNumber +
                ", marksList=" + marksList +
                '}';
    }
}

