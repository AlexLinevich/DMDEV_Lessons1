package by.lav.homework112.thread;

import by.lav.homework112.dto.Complaint;
import by.lav.homework112.dto.ComplaintsForExecute;
import by.lav.homework112.dto.ExecutedComplaint;
import by.lav.homework112.parser.LogFileParser;
import by.lav.homework112.writer.LogFileWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.SECONDS;

public class ComplaintExecutor extends Thread {

    private final Path path;
    private final ComplaintsForExecute complaints;

    public ComplaintExecutor(Path path, ComplaintsForExecute complaints) {
        this.path = path;
        this.complaints = complaints;
    }

    @Override
    public void run() {
        while (!complaints.getComplaints().isEmpty()) {
            if (complaints.getLock().tryLock()) {
                try {
                    Complaint complaint = complaints.takeComplaint();
                    String phoneNumber = LogFileParser.parseAndNormalisePhoneNumber(complaint.getClient().getPhoneNumber());
                    ExecutedComplaint executedComplaint =
                            new ExecutedComplaint(complaint.getId(), LocalDateTime.now(), phoneNumber);
                    String time = executedComplaint.getTime().truncatedTo(SECONDS).format(DateTimeFormatter.ISO_DATE_TIME);
                    CharSequence report = String.join(", ",
                            String.valueOf(executedComplaint.getId()), time, executedComplaint.getPhoneNumber()) +
                            System.lineSeparator();
                    LogFileWriter.writeLogFile(path, report);
                    System.out.println(Thread.currentThread().getName() + " executed complaint id: " + complaint.getId());
                    complaints.getLock().unlock();
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
