package utils.postcode;

public class PostcodeComparer {
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
