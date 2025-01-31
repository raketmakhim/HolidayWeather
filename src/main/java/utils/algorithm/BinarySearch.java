package utils.algorithm;

import java.util.List;

import static utils.postcode.PostcodeComparer.comparePostcodes;

public class BinarySearch {
    // Binary search to find the row with the given post code
    public static String[] search(List<String[]> records, String searchPostCode) {
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
}
