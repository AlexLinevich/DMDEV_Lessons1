package by.lav.homework75;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public final class HW75Utils {

    private HW75Utils() {
    }

    public static List<String[]> readFile(Path path) {
        List<String[]> strings = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.lines()
                        .flatMap(String::lines)
                        .map(s -> s.split(","))
                        .collect(Collectors.toList());
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        return strings;
    }

    public static List<Item> joinFiles(List<String[]> list1, List<String[]> list2) {
        List<Item> result = list1.stream()
                .map(string -> new Item(Integer.parseInt(string[0]), string[1], string[2], null))
                .collect(Collectors.toList());
        for (String[] strings : list2) {
            int id = Integer.parseInt(strings[0]);
            boolean isContain = false;
            for (Item item : result) {
                if (item.getId() == id) {
                    item.setPrice(Double.parseDouble(strings[1]));
                    isContain = true;
                }
            }
            if (!isContain) {
                result.add(new Item(Integer.parseInt(strings[0]), null, null, Double.parseDouble(strings[1])));
            }
        }
        return result;
    }

    public static void printItemsToFiles(List<Item> items, Path path1, Path path2) throws IOException {
        for (Item item : items) {
            if (item.getName() != null && item.getPrice() != null) {
                String string1 = item.getId() + "," + item.getName() + "," + item.getPrice() + System.lineSeparator();
                Files.writeString(path1, string1, CREATE, APPEND);
            } else {
                String string2 = item.getId() + System.lineSeparator();
                Files.writeString(path2, string2, CREATE, APPEND);
            }
        }
    }
}
