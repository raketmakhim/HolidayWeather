package utils.factory;

import utils.postcode.LocationFinder;

import java.io.IOException;

public class LocationFinderFactory {

    public LocationFinder create(String postcode) throws IOException {
        return new LocationFinder(postcode);
    }
}