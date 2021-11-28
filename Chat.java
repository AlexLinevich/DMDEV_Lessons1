package by.lav.homework50;

public class Chat implements Comparable<Chat> {

    private final String chatName;
    private final int chatQuantity;

    public Chat(String chatName, int chatQuantity) {
        this.chatName = chatName;
        this.chatQuantity = chatQuantity;
    }

    @Override
    public int compareTo(Chat o) {
        return chatName.compareTo(o.chatName);
    }

    public String getChatName() {
        return chatName;
    }

    public int getChatQuantity() {
        return chatQuantity;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "chatName='" + chatName + '\'' +
                ", chatQuantity=" + chatQuantity +
                '}';
    }
}
