package by.lav.homework112.thread;

import by.lav.homework112.dto.Complaint;
import by.lav.homework112.dto.ComplaintsForExecute;
import by.lav.homework112.parser.LogFileParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class LogFileReader extends Thread {

    private final Path path;
    private final ComplaintsForExecute complaints;

    public LogFileReader(Path path, ComplaintsForExecute complaints) {
        this.path = path;
        this.complaints = complaints;
    }

    @Override
    public void run() {
        if (complaints.getLock().tryLock()) {
            try {
                List<Complaint> tempList = LogFileParser.parseRow(path);
                int idChecker = complaints.getMaxIdAdded();
                List<Complaint> list = tempList.stream()
                        .filter(complaint -> complaint.getId() > idChecker)
                        .collect(Collectors.toList());
                complaints.addComplaints(list);
                System.out.println(Thread.currentThread().getName() + " read " + list.size() + " new complaints");
                complaints.getLock().unlock();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
