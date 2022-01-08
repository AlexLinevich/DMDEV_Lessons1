package by.lav.homework112.dto;

import java.time.LocalDateTime;

public class ExecutedComplaint {

    private final int id;
    private final LocalDateTime time;
    private final String phoneNumber;

    public ExecutedComplaint(int id, LocalDateTime time, String phoneNumber) {
        this.id = id;
        this.time = time;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
