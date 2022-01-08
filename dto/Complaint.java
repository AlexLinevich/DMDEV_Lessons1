package by.lav.homework112.dto;

public class Complaint {

    private final int id;
    private final Client client;
    private final String time;
    private final String complaint;

    public Complaint(int id, Client client, String time, String complaint) {
        this.id = id;
        this.client = client;
        this.time = time;
        this.complaint = complaint;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public String getTime() {
        return time;
    }

    public String getComplaint() {
        return complaint;
    }
}
