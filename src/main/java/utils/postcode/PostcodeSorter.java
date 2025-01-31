package utils.postcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PostcodeSorter {
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
}
