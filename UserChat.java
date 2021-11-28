package by.lav.homework50;

import java.util.List;

public class UserChat {

    private final String chatName;
    private final List<User> userList;

    public UserChat(String chatName, List<User> userList) {
        this.chatName = chatName;
        this.userList = userList;
    }

    public String getChatName() {
        return chatName;
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return "UserChat{" +
                "chatName='" + chatName + '\'' +
                ", userList=" + userList +
                '}';
    }
}
