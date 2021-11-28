package by.lav.homework50;

import java.util.*;

/**
 * Дан список чатов. Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public class HW50Task1 {

    public static void main(String[] args) {
        List<Chat> chats = Arrays.asList(
                new Chat("MusicChat", 1200),
                new Chat("SoccerChat", 900),
                new Chat("RacingChat", 1800),
                new Chat("HockeyChat", 600),
                new Chat("PublicChat", 1500),
                new Chat("PrivateChat", 2500),
                new Chat("AutoChat", 1500),
                new Chat("PubChat", 1050),
                new Chat("GlobalChat", 500),
                new Chat("SuperChat", 9500)
        );
        List<Chat> chatList = new ArrayList<>(chats);

        ListIterator<Chat> listIterator = chatList.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getChatQuantity() < 1000) {
                listIterator.remove();
            }
        }
        printList(chatList);

        System.out.println();
        chatList.sort(new ChatQuantityComparator().thenComparing(new ChatNameComparator()));
        printList(chatList);

        System.out.println();
        Collections.sort(chats);
        printList(chats);
    }

    public static <E> void printList(List<E> list) {
        for (E e : list) {
            System.out.println(e);
        }
    }
}
