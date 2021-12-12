package by.lav.homework75;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class HW75TaskRunner {

    public static void main(String[] args) throws IOException {
        Path inputPath1 = Path.of("resources", "items-name.csv");
        Path inputPath2 = Path.of("resources", "items-price.csv");
        Path outputPath1 = Path.of("resources", "result.csv");
        Path outputPath2 = Path.of("resources", "errors.csv");

        List<Item> items = HW75Utils.joinFiles(HW75Utils.readFile(inputPath1), HW75Utils.readFile(inputPath2));
        HW75Utils.printItemsToFiles(items, outputPath1, outputPath2);
    }
}

