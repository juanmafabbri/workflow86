package helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Printer {


    public static void printInitialData(String title, HashMap<String, List<String>> data) {
        System.out.format("%n%n++++++++++++++++++++++++++++++++++++%n%n");
        System.out.println(title);
        String leftAlignFormat = "| %-15s | %-14s |%n";

        System.out.format("+-----------------+----------------+%n");
        System.out.format("| Module Id       | Dependencies   |%n");
        System.out.format("+-----------------+----------------+%n");

        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            System.out.format(leftAlignFormat, entry.getKey(), entry.getValue());
        }

        System.out.format("+-----------------+----------------+%n");
    }

    public static void printResult(String moduleName, List<String> output) {
        StringJoiner joiner = new StringJoiner(",");
        output.forEach(value -> joiner.add(value));

        System.out.println("Dependencies for Module "+ moduleName +": {"+ joiner.toString() +"}");
    }
}
