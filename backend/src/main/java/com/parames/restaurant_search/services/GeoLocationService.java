package com.parames.restaurant_search.services;

import com.parames.restaurant_search.domain.GeoLocation;
import com.parames.restaurant_search.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
