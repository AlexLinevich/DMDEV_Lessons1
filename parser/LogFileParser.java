package by.lav.homework112.parser;

import by.lav.homework112.dto.Client;
import by.lav.homework112.dto.Complaint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class LogFileParser {

    private static final String ID_GROUP = "id";
    private static final String TIME_GROUP = "time";
    private static final String NAME_GROUP = "name";
    private static final String PHONE_GROUP = "phone";
    private static final String COMPLAINT_GROUP = "complaint";
    private static final String LOG_FILE_REGEXP = "^(?<id>\\d+), ?(?<time>[\\d\\-T:]{2,}), ?(?<name>[а-яА-Я ]{2,}), ?" +
            "(?<phone>[+\\d() \\-]{7,}), ?(?<complaint>.+)$";
    private static final Pattern PATTERN = Pattern.compile(LOG_FILE_REGEXP);

    private LogFileParser() {
    }

    public static List<Complaint> parseRow(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .map(PATTERN::matcher)
                    .filter(Matcher::find)
                    .map(matcher -> {
                        var id = Integer.parseInt(matcher.group(ID_GROUP));
                        var time = matcher.group(TIME_GROUP);
                        var name = matcher.group(NAME_GROUP);
                        var phone = matcher.group(PHONE_GROUP);
                        var client = new Client(name, phone);
                        var complaint = matcher.group(COMPLAINT_GROUP);
                        return new Complaint(id, client, time, complaint);
                    })
                    .collect(toList());
        }
    }

    public static String parseAndNormalisePhoneNumber(String phone) {
        String phoneRegexp =
                "^\\+?(?<country>375)? ?\\(?(?<code>[\\d]{2})\\)? ?" +
                        "(?<digits1>[\\d]{3})[- ]?(?<digits2>[\\d]{2})[- ]?(?<digits3>[\\d]{2})$";
        Pattern pattern = Pattern.compile(phoneRegexp);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.find()) {
            return "+375 (" + matcher.group("code") + ") "
                    + matcher.group("digits1") + "-" + matcher.group("digits2") + "-" + matcher.group("digits3");
        } else {
            return "incorrect phone number format";
        }
    }
}
