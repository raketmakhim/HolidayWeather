package utils.algorithm;

import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    private final Comparator<String> postcodeComparator;

    // Constructor Injection
    public BinarySearch(Comparator<String> postcodeComparator) {
        this.postcodeComparator = postcodeComparator;
    }

    public String[] search(List<String[]> records, String searchPostCode) {
        int left = 1; // Skip header
        int right = records.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String[] midRecord = records.get(mid);
            String midPostCode = midRecord[1]; // Assuming postcode is in column 1

            int comparison = postcodeComparator.compare(midPostCode, searchPostCode);

            if (comparison == 0) {
                return midRecord; // Found postcode
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null; // Not found
    }
}
