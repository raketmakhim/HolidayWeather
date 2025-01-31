package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvSearch {
    // Read CSV file and store records in a List
    public static List<String[]> readCsv(String fileName) throws IOException {
        List<String[]> records = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            records.add(line.split(","));  // Split each line by comma and add to list
        }
        reader.close();
        return records;
    }

    // Write sorted records to a new CSV file
    public static void writeCsv(String fileName, List<String[]> records) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String[] record : records) {
            writer.write(String.join(",", record));  // Join columns with commas and write to file
            writer.newLine();  // Move to the next line
        }
        writer.close();
    }


}
