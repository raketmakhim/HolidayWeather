package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
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

    // Sort records by postcode (assuming postcode is in the first column)
    public static void sortByPostcode(List<String[]> records) {
        // Skip the header row when sorting, we will keep the header intact
        String[] header = records.get(0);  // Save the header
        List<String[]> data = new ArrayList<>(records.subList(1, records.size()));  // Extract the data part

        data.sort(Comparator.comparing(record -> record[1]));  // Sorting by postcode (first column)

        // Re-insert the header at the top after sorting
        records.clear();
        records.add(header);
        records.addAll(data);
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

    // Binary search to find the row with the given post code
    public static String[] binarySearch(List<String[]> records, String searchPostCode) {
        int left = 1;  // Start from index 1 to skip header
        int right = records.size() - 1;  // Last index in the list

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String[] midRecord = records.get(mid);
            String midPostCode = midRecord[1]; // Assuming post code is the first field

            if (midPostCode.equals(searchPostCode)) {
                return midRecord;  // Found the matching post code
            } else if (comparePostcodes(midPostCode, searchPostCode) < 0) {
                left = mid + 1;  // Move to the right half
            } else {
                right = mid - 1;  // Move to the left half
            }
        }

        return null;  // Post code not found
    }

    public static int comparePostcodes(String postcode1, String postcode2) {
        // Split postcodes by the space
        String[] parts1 = postcode1.split(" ");
        String[] parts2 = postcode2.split(" ");

        // Validate that both postcodes have exactly two parts
        if (parts1.length == 2 && parts2.length == 2) {
            String outward1 = parts1[0];
            String inward1 = parts1[1];
            String outward2 = parts2[0];
            String inward2 = parts2[1];

            // Compare outward codes first
            int outwardComparison = outward1.compareTo(outward2);
            if (outwardComparison != 0) {
                return outwardComparison; // Return result if outward codes differ
            }

            // Compare inward codes if outward codes are equal
            return inward1.compareTo(inward2);
        }

        // Handle invalid postcodes (place them at the end)
        return postcode1.compareTo(postcode2);
    }
}
