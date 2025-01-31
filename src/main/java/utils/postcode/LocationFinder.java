package utils.postcode;

import utils.CsvSearch;
import utils.algorithm.BinarySearch;

import java.io.IOException;
import java.util.List;

public class LocationFinder {
    private String[] record;
    private String longitude;
    private String latitude;
    private final String POSTCODE_DATA_FILE_URI = "src/main/resources/data/SortedPostCodes.csv";

    public LocationFinder(String postcode) throws IOException {
        this.record = getRecord(postcode);
        this.longitude = this.record[2];
        this.latitude = this.record[3];
    }

    private String[] getRecord(String postcode) throws IOException {
        List<String[]> records = CsvSearch.readCsv(POSTCODE_DATA_FILE_URI);
        return BinarySearch.search(records, postcode);
    }

    public String getLongitude(){
        return this.longitude;
    }

    public String getLatitude(){
        return this.latitude;
    }


}
