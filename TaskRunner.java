package by.lav.homework112;

import by.lav.homework112.dto.ComplaintsForExecute;
import by.lav.homework112.parser.LogFileParser;
import by.lav.homework112.thread.ComplaintExecutor;
import by.lav.homework112.thread.ComplaintGenerator;
import by.lav.homework112.thread.LogFileReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskRunner {

    public static void main(String[] args) throws IOException {
        var inputLogFilePath = Path.of("resources", "complaints.log");
        var outputLogFilePath = Path.of("resources", "executed_complaints.log");
        var examplesLogFilePath = Path.of("resources", "complaints_example.log");
        var complaints = new ComplaintsForExecute(LogFileParser.parseRow(inputLogFilePath));
        var threadPool = Executors.newScheduledThreadPool(4);

        threadPool.scheduleAtFixedRate(new ComplaintGenerator(inputLogFilePath, examplesLogFilePath, complaints),
                1L, 20L, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(new LogFileReader(inputLogFilePath, complaints),
                5L, 60L, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(new ComplaintExecutor(outputLogFilePath, complaints),
                10L, 30L, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(new ComplaintExecutor(outputLogFilePath, complaints),
                10L, 30L, TimeUnit.SECONDS);

//        threadPool.shutdown();
//        threadPool.awaitTermination(1L, TimeUnit.HOURS);
    }
}
