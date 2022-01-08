package by.lav.homework112.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ComplaintsForExecute {

    private final List<Complaint> complaints = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private int maxIdAdded;

    public ComplaintsForExecute(List<Complaint> list) {
        addComplaints(list);
    }

    public void addComplaints(List<Complaint> list) {
        complaints.addAll(list);
        maxIdAdded = list.stream()
                .map(Complaint::getId)
                .reduce(maxIdAdded, Math::max);
    }

    public Complaint takeComplaint() {
        return complaints.remove(0);
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public Lock getLock() {
        return lock;
    }

    public int getMaxIdAdded() {
        return maxIdAdded;
    }
}
