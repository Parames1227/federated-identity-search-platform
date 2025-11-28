package com.parames.restaurant_search.mappers;

import com.parames.restaurant_search.domain.ReviewCreateUpdateRequest;
import com.parames.restaurant_search.domain.dtos.ReviewCreateUpdateRequestDto;
import com.parames.restaurant_search.domain.dtos.ReviewDto;
import com.parames.restaurant_search.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateRequestDto dto);

    ReviewDto toDto(Review review);

}
