package by.lav.homework50;

public class User {

    private final int id;
    private final String userName;
    private final int userAge;

    public User(int id, String userName, int userAge) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
