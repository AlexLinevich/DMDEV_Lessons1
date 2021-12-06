package by.lav.homework66;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * 1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * 2. Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class HW66Task {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alex", "Alekseev", 1, List.of(8, 9, 8, 5, 10)),
                new Student("Stepan", "Novikov", 1, List.of(7, 9, 8, 9)),
                new Student("Petr", "Petrov", 2, List.of(9, 9)),
                new Student("Sveta", "Sidorova", 2, List.of(7, 5, 6, 7, 8, 9)),
                new Student("Yury", "Orlov", 3, List.of(7, 4, 8, 9, 8, 8)),
                new Student("Ivan", "Sokolov", 3, List.of(6, 7, 4, 9, 8, 9)),
                new Student("Ivan", "Kolosov", 1, List.of(10, 7, 4, 9, 8, 9))
        );

        Map<Integer, Double> studentsMapByCursAndAverageMarks = getStudentsMapByCursAndAverageMark(students, 3);

        System.out.println(students);
        System.out.println(studentsMapByCursAndAverageMarks);

        Map<Integer, List<StudentShort>> studentsMapByCursAndFullName = getStudentsMapByCursAndFullName(students);
        System.out.println(studentsMapByCursAndFullName);
        System.out.println(getStudentsMapByCursAndFullNameStream(students));

        Map<Integer, Double> studentsMapByCursAndAverageMarks2 = getStudentsMapByCursAndAverageMark(students, -1);

        for (Integer curs : studentsMapByCursAndFullName.keySet()) {
            System.out.println("Студенты курса " + curs + ": " +
                    new StudentsListObject(studentsMapByCursAndFullName.get(curs),
                            studentsMapByCursAndAverageMarks2.get(curs)));
        }
    }

    public static Map<Integer, Double> getStudentsMapByCursAndAverageMark(List<Student> students, int marksLimit) {
        Map<Integer, List<Integer>> tempStudentsMap = new TreeMap<>();
        for (Student student : students) {
            List<Integer> marksList = tempStudentsMap.getOrDefault(student.getCursNumber(), new ArrayList<>());
            if (student.getMarksList().size() > marksLimit && marksLimit >= 0) {
                marksList.addAll(student.getMarksList());
            } else if (marksLimit < 0) {
                marksList.addAll(student.getMarksList());
            }
            tempStudentsMap.put(student.getCursNumber(), marksList);
        }

//        Попытался переписать код выше на функциональный стиль и так и не разобрася как селать одну
//        коолекцию List (аналог метода addAll в коде выше) вместо List<List>
        Map<Integer, List<List<Integer>>> collect = students.stream()
                .filter(student -> student.getMarksList().size() > marksLimit)
                .collect(Collectors.groupingBy(Student::getCursNumber,
                        Collectors.mapping(Student::getMarksList, Collectors.toList())));

        Map<Integer, Double> studentsMapByCursAndAverageMarks = new TreeMap<>();
        for (Map.Entry<Integer, List<Integer>> integerListEntry : tempStudentsMap.entrySet()) {
            Integer sumMarks = 0;
            for (Integer mark : integerListEntry.getValue()) {
                sumMarks += mark;
            }
            studentsMapByCursAndAverageMarks.put(integerListEntry.getKey(),
                    (double) sumMarks / integerListEntry.getValue().size());
        }

//        Попытался переписать код выше на функциональный стиль и так и не разобрася как это сделать
//        tempStudentsMap.entrySet().stream()
//                .map(Map.Entry::getValue)
//                .map(value ->)

        return studentsMapByCursAndAverageMarks;
    }

    public static Map<Integer, List<StudentShort>> getStudentsMapByCursAndFullName(List<Student> students) {
        Map<Integer, List<StudentShort>> studentsMapByCursAndFullName = new TreeMap<>();
        for (Student student : students) {
            List<StudentShort> studentsShortList = studentsMapByCursAndFullName.getOrDefault(student.getCursNumber(),
                    new ArrayList<>());
            studentsShortList.add(new StudentShort(student.getName(), student.getSurname()));
            studentsShortList.sort(new StudentShortSortedByFullName());
            studentsMapByCursAndFullName.put(student.getCursNumber(), studentsShortList);
        }
        return studentsMapByCursAndFullName;
    }

    public static Map<Integer, List<String>> getStudentsMapByCursAndFullNameStream(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(Student::getCursNumber,
                Collectors.mapping(Student::getFullName, Collectors.toList())));
        // Не разобрался как сюда вставить коллекцию новых обектов с двумя полями и как сюда воткнуть еще и сортировку.
    }
}