package by.lav.homework50;

import java.util.Comparator;

public class ChatQuantityComparator implements Comparator<Chat> {

    @Override
    public int compare(Chat o1, Chat o2) {
        return -Integer.compare(o1.getChatQuantity(), o2.getChatQuantity());
    }
}
