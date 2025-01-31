package utils.postcode;

import java.util.Comparator;

public class PostcodeComparator implements Comparator<String> {
    @Override
    public int compare(String postcode1, String postcode2) {
        String[] parts1 = postcode1.split(" ");
        String[] parts2 = postcode2.split(" ");

        if (parts1.length == 2 && parts2.length == 2) {
            int outwardComparison = parts1[0].compareTo(parts2[0]);
            if (outwardComparison != 0) {
                return outwardComparison;
            }
            return parts1[1].compareTo(parts2[1]);
        }

        // Handle invalid postcodes
        return postcode1.compareTo(postcode2);
    }
}