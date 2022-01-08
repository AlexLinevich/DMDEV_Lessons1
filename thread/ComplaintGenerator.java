package by.lav.homework112.thread;

import by.lav.homework112.dto.Complaint;
import by.lav.homework112.dto.ComplaintsForExecute;
import by.lav.homework112.parser.LogFileParser;
import by.lav.homework112.writer.LogFileWriter;
import by.lav.homework94.util.RandomUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ComplaintGenerator extends Thread {

    private final Path logFilePath;
    private final ComplaintsForExecute complaints;
    private final List<Complaint> complaintExamples = new ArrayList<>();
    private int id;


    public ComplaintGenerator(Path logFilePath, Path examplesPath, ComplaintsForExecute complaints) throws IOException {
        this.logFilePath = logFilePath;
        this.complaints = complaints;
        this.complaintExamples.addAll(LogFileParser.parseRow(examplesPath));
        this.id = complaints.getMaxIdAdded();
    }

    @Override
    public void run() {
        if (complaints.getLock().tryLock()) {
            try {
                int quantityComplaintsToAdd = RandomUtil.getRandomBetween(1, 5);
                for (int i = 0; i < quantityComplaintsToAdd; i++) {
                    int listIndex = RandomUtil.getRandomFrom(complaintExamples.size() - 1);
                    Complaint complaint = complaintExamples.get(listIndex);
                    CharSequence report = String.join(", ",
                            String.valueOf(++id), complaint.getTime(), complaint.getClient().getName(),
                            complaint.getClient().getPhoneNumber(), complaint.getComplaint()) + System.lineSeparator();
                    LogFileWriter.writeLogFile(logFilePath, report);
                }
                System.out.println(Thread.currentThread().getName() + " added " + quantityComplaintsToAdd + " new complaints");
                complaints.getLock().unlock();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
