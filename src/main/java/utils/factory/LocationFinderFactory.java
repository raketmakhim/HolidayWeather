package utils.factory;

import utils.algorithm.BinarySearch;
import utils.postcode.LocationFinder;

import java.io.IOException;

public class LocationFinderFactory {
    private final BinarySearch binarySearch;

    // Inject BinarySearch in the factory constructor
    public LocationFinderFactory(BinarySearch binarySearch) {
        this.binarySearch = binarySearch;
    }

    public LocationFinder create(String postcode) throws IOException {
        return new LocationFinder(postcode, binarySearch); // Injecting BinarySearch
    }
}
