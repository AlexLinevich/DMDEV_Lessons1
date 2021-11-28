package by.lav.homework50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей” будет список
 * объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
 * Задача:
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей
 */
public class HW50Task2 {

    public static void main(String[] args) {
        List<UserChat> chats = Arrays.asList(
                new UserChat("MusicChat", Arrays.asList(
                        new User(1, "Sveta", 17),
                        new User(2, "Slava", 21),
                        new User(3, "Roman", 23)
                )),
                new UserChat("SoccerChat", Arrays.asList(
                        new User(4, "Nick", 15),
                        new User(5, "Mike", 21),
                        new User(6, "Stas", 22)
                )),
                new UserChat("RacingChat", Arrays.asList(
                        new User(7, "Ivan", 10),
                        new User(8, "Vova", 28),
                        new User(9, "Vlad", 23)
                ))
        );

        List<User> userList = new ArrayList<>();

        for (UserChat chat : chats) {
            for (User user : chat.getUserList()) {
                if (user.getUserAge() > 18)
                    userList.add(user);
            }
        }

        HW50Task1.printList(userList);

        System.out.println("Средний возраст пользователей: " + getAverageAge(userList));
    }

    public static double getAverageAge(List<User> userList) {
        double sumAges = 0;
        for (User user : userList) {
            sumAges += user.getUserAge();
        }
        return sumAges / userList.size();
    }
}
