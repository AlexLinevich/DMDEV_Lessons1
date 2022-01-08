package by.lav.homework112.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.CREATE;

public final class LogFileWriter {

    private LogFileWriter() {
    }

    public static void writeLogFile(Path path, CharSequence report) throws IOException {
        Files.writeString(path, report, CREATE, StandardOpenOption.APPEND);
    }
}
