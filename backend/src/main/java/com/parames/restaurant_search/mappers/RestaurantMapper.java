package com.parames.restaurant_search.mappers;

import com.parames.restaurant_search.domain.RestaurantCreateUpdateRequest;
import com.parames.restaurant_search.domain.dtos.GeoPointDto;
import com.parames.restaurant_search.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.parames.restaurant_search.domain.dtos.RestaurantDto;
import com.parames.restaurant_search.domain.dtos.RestaurantSummaryDto;
import com.parames.restaurant_search.domain.entities.Restaurant;
import com.parames.restaurant_search.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantSummaryDto toSummaryDto(Restaurant restaurant);

    @Named("populateTotalReviews")
    default Integer populateTotalReviews(List<Review> reviews) {

        if (reviews == null) {
            return 0;
        }
        return reviews.size();
    }

    @Mapping(target = "latitude", expression = "java(geoPoint.getLat())")
    @Mapping(target = "longitude", expression = "java(geoPoint.getLon())")
    GeoPointDto toGeoPointDto(GeoPoint geoPoint);
}
