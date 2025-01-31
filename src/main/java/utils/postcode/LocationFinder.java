package utils.postcode;

import utils.CsvSearch;
import utils.algorithm.BinarySearch;

import java.io.IOException;
import java.util.List;

public class LocationFinder {
    private final String[] record;
    private final String longitude;
    private final String latitude;
    private final String POSTCODE_DATA_FILE_URI = "src/main/resources/data/SortedPostCodes.csv";
    private final BinarySearch binarySearch;

    // Inject BinarySearch through constructor
    public LocationFinder(String postcode, BinarySearch binarySearch) throws IOException {
        this.binarySearch = binarySearch; // Dependency Injection
        this.record = getRecord(postcode);
        this.longitude = this.record[2];
        this.latitude = this.record[3];
    }

    private String[] getRecord(String postcode) throws IOException {
        List<String[]> records = CsvSearch.readCsv(POSTCODE_DATA_FILE_URI);
        return binarySearch.search(records, postcode); // Use injected instance
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }
}
